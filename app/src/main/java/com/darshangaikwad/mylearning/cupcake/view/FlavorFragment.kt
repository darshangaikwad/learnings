package com.darshangaikwad.mylearning.cupcake.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.darshangaikwad.mylearning.R
import com.darshangaikwad.mylearning.cupcake.viewmodel.OrderViewModel
import com.darshangaikwad.mylearning.databinding.FragmentFlavorBinding

/**
 * Created by Darshan Gaikwad on 17,August,2021
 */
class FlavorFragment : Fragment() {

    // Binding object instance corresponding to the fragment_flavor.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentFlavorBinding? = null
    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentFlavorBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            flavorFragment = this@FlavorFragment
        }
    }

    /**
     * Navigate to the next screen to choose pickup date.
     */
    fun goToNextScreen() {
        findNavController().navigate(R.id.action_flavorFragment_to_pickupFragment)
        Toast.makeText(activity, "Next", Toast.LENGTH_SHORT).show()
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}