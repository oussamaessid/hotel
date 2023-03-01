package com.example.hotelwallet.presentation.welcome



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelwallet.databinding.RowItemWelcomeBinding
import com.example.hotelwallet.domain.model.LayoutUiModel


class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    private var items :List<LayoutUiModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerAdapter.ViewHolder {
        val binding = RowItemWelcomeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewHolder, position: Int) {
         holder.BindContent(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setViewPageAdapter(layoutUiModel: List<LayoutUiModel>){
        items = layoutUiModel
    }
    inner class ViewHolder(val binding: RowItemWelcomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

            val title = binding.txtTitleSlide
            val desc = binding.txtDesSlide
            val image = binding.imgSlide
        fun  BindContent(layoutUiModel: LayoutUiModel){
            title.text = layoutUiModel.title
            desc.text = layoutUiModel.description
            image.setBackgroundResource(layoutUiModel.image)
        }
    }
}




