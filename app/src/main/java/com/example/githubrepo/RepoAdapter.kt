package com.example.githubrepo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.githubrepo.databinding.ItemRepoBinding
import com.example.githubrepo.model.Repository

class RepoAdapter(
    private val repos: List<Repository>,
    private val onClick: (Repository) -> Unit
) : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    inner class RepoViewHolder(private val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(repo: Repository) {
            binding.repoName.text = repo.name
            binding.repoDescription.text = repo.description
            binding.repoOwnerAvatar.load(repo.owner.avatar_url)

            binding.root.setOnClickListener {
                onClick(repo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun getItemCount(): Int = repos.size
}