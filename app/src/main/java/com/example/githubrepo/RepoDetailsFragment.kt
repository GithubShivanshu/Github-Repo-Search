package com.example.githubrepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.githubrepo.databinding.FragmentRepoDetailsBinding
import com.example.githubrepo.model.Repository

class RepoDetailsFragment : Fragment() {

    private var _binding: FragmentRepoDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repo = arguments?.getParcelable<Repository>("repo")
        repo?.let {
            binding.repoName.text = it.name
            binding.repoDescription.text = it.description
            binding.repoOwnerAvatar.load(it.owner.avatar_url)
            // other details
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}