package kz.stepanenkos.photosfromnasa.allDates.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kz.stepanenkos.photosfromnasa.databinding.FragmentPicturesOfTheDaysBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PicturesOfTheDaysFragment : Fragment() {
    private val viewModel by viewModel<PicturesOfTheDaysViewModel>()

    private var _binding: FragmentPicturesOfTheDaysBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPicturesOfTheDaysBinding.inflate(inflater, container, false)
        viewModel.getAllDates()
        viewModel.text.observe(viewLifecycleOwner) {
            Log.d("TAG", "$it")
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Log.d("TAG", "$it")
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}