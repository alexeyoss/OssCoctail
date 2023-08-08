package ru.alexeyoss.features.coctails_list.presentation.coctails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.alexeyoss.features.coctails_list.R
import ru.alexeyoss.features.coctails_list.databinding.ItemCoctailsListBinding
import ru.alexeyoss.features.coctails_list.domain.entitites.UiCoctail

class CoctailsAdapter(
    private val onCoctailClick: (UiCoctail) -> Unit
) : ListAdapter<UiCoctail, CoctailsAdapter.CoctailHolder>(diffUtil) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctailHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCoctailsListBinding.inflate(inflater, parent, false)
        return CoctailHolder(binding, onCoctailClick)
    }

    override fun onBindViewHolder(holder: CoctailHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    inner class CoctailHolder(
        private val binding: ItemCoctailsListBinding, private val onCoctailClick: (UiCoctail) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            with(binding) {
                root.setOnClickListener {
                    if (bindingAdapterPosition == RecyclerView.NO_POSITION) return@setOnClickListener
                    val item = currentList[bindingAdapterPosition]
                    onCoctailClick(item)
                }
            }
        }

        fun onBind(item: UiCoctail) {
            with(binding) {
                coctailName.text = item.title
                Glide.with(itemView.context)
                    .load(R.drawable.example_placeholder)
                    .centerCrop()
                    .into(backgroundImage)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<UiCoctail>() {
            override fun areItemsTheSame(oldItem: UiCoctail, newItem: UiCoctail): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UiCoctail, newItem: UiCoctail): Boolean {
                return oldItem == newItem
            }
        }
    }

}