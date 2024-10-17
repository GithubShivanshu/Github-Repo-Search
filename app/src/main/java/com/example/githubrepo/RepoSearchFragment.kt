package com.example.githubrepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubrepo.databinding.FragmentRepoSearchBinding
import com.example.githubrepo.viewmodel.RepoViewModel

class RepoSearchFragment : Fragment() {

    private var _binding: FragmentRepoSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RepoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepoSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        binding.searchButton.setOnClickListener {
            val query = binding.searchInput.text.toString()
            if (query.isNotEmpty()) {
                viewModel.searchRepositories(query, 1)
            }
        }

        viewModel.repositories.observe(viewLifecycleOwner) { repos ->
            val adapter = RepoAdapter(repos) { repo ->
                // Handle repository click (navigate to details)
            }
            binding.repoRecyclerView.adapter = adapter
        }
    }

    private fun setupRecyclerView() {
        binding.repoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}