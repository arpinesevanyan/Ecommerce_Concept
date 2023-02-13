package com.codeschool.myapplication.ui.guardian

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codeschool.guardian.news.data.NewsItemDto
import com.codeschool.myapplication.databinding.ItemGuardianNewsBinding

class GuardianNewsAdapter(private val onItemClick: (NewsItemDto) -> Unit) :
    RecyclerView.Adapter<GuardianNewsAdapter.BaseViewHolder>() {

    private val items: MutableList<NewsItemDto?> = mutableListOf()

    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        NewsViewHolder(ItemGuardianNewsBinding.inflate(layoutInflater, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) =
        holder.bind(items[position])

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(items: List<NewsItemDto?>?) {
        items?.let {
            this.items.clear()
            this.items.addAll(it)
        }
        notifyDataSetChanged()
    }

    abstract inner class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: NewsItemDto?)
    }

    inner class NewsViewHolder(private val binding: ItemGuardianNewsBinding) :
        BaseViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                items[absoluteAdapterPosition]?.let { it1 -> onItemClick(it1) }
            }
            binding.favoriteImageView.setOnClickListener {
                if ((it as ImageView).isSelected) {
                    items[absoluteAdapterPosition]?.id?.let { it1 ->
                        (context as GuardianNewsActivity).favoriteViewModel.deleteNewsById(
                            it1
                        )
                    }
                } else {
                    items[absoluteAdapterPosition]?.let { dto ->
                        (context as GuardianNewsActivity).favoriteViewModel.saveNews(
                            dto
                        )
                    }
                }
            }
        }

        override fun bind(item: NewsItemDto?) {
            binding.titleTextView.text = item?.sectionName
            binding.descriptionTextView.text = item?.webTitle
            binding.publicationDateTextView.text = item?.webPublicationDate
            item?.fields?.thumbnail.let {
                Glide.with(context).load(item?.fields?.thumbnail).centerCrop()
                    .into(binding.contentImageView)
            }
            binding.favoriteImageView.isSelected =
                (context as? GuardianNewsActivity)?.favoriteViewModel?.favoriteNews?.value?.find { it.id == item?.id } != null
        }
    }
}