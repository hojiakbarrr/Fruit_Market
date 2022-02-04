package com.example.fruitmarket.window_main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.fruitmarket.DataBase.FruitAdapter
import com.example.fruitmarket.FruitsData
import com.example.fruitmarket.R
import com.example.fruitmarket.databinding.FragmentMainScreenBinding


class Main_screenFragment : Fragment(), FruitAdapter.IconClickListener {

    val oldNotes by navArgs<DetailFragmentArgs>()


    lateinit var binding: FragmentMainScreenBinding
    var fruitList: MutableList<FruitsData> = ArrayList()
    var searchList: MutableList<FruitsData> = ArrayList()
    private var adapter: FruitAdapter? = null

    var unlike = R.drawable.un_favorite
    var like = R.drawable.favorite

    var apple = R.drawable.app
    var apricots = R.drawable.apricots
    var grapes = R.drawable.grapes
    var melon = R.drawable.melon
    var multiFruit = R.drawable.multi_fruit
    var nectarines = R.drawable.nectarines
    var oranges = R.drawable.oranges
    var peaches = R.drawable.peaches
    var pumpkin = R.drawable.pumpkin
    var strawberry = R.drawable.strawberry
    var tropicano = R.drawable.tropicano
    var water_mealons = R.drawable.water_mealons

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainScreenBinding.inflate(layoutInflater, container, false)


        //*/*/*/*/*/*/*/*/*/*/*/*/*/*/*--------------> SEARCH <------------/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*

        binding.searchField.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.lowercase()
                if (searchText.isNotEmpty()) {
                    for (o in fruitList) {
                        if (o.title.lowercase().contains(searchText))
                            searchList.add(o)
                    }
                    adapter?.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(fruitList)
                    adapter?.notifyDataSetChanged()
                }
                return false

            }


        })
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*--------------> SEARCH <------------/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.clear()
        fruitList.add(FruitsData(unlike,
            apple,
            "Apple",
            "56",
            "• Calories: 104\n" +
                    "• Carbs: 28 grams\n" +
                    "• Fiber: 5 grams\n" +
                    "• Vitamin C: 10% of the Daily Value (DV)\n" +
                    "• Copper: 6% of the DV\n" +
                    "• Potassium: 5% of the DV",
            "Apples have been shown to reduce your body’s cholesterol and inflammation levels, " +
                    "which are both key factors for heart health "))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            apricots,
            "Apricots",
            "47,12",
            "• Calories: 34\n" +
                    "• Carbs: 8 grams\n" +
                    "• Fiber: 1,5 grams\n" +
                    "• Vitamin C: 8% of the DV\n" +
                    "• Vitamin E: 4% of the DV\n" +
                    "• Vitamin A: 8% of the Daily Value (DV)",
            "Rich in vitamin A, beta-carotene, and other carotenoids, apricots are excellent f" +
                    "or promoting eye health. Lutein helps to support retina and lens health, whil" +
                    "e carotenoids and vitamin E support overall vision. Apricot nutrients " +
                    "also help to reduce the risk of macular degeneration and cataracts."))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            grapes,
            "Grapes",
            "62,31",
            "• Calories: 104\n" +
                    "• Carbs: 27 grams\n" +
                    "• Fiber: 1.4 grams\n" +
                    "• Vitamin C: 5% of the DV\n" +
                    "• Vitamin E:2% of the DV\n" +
                    "• Vitamin K: 18% of the DV",
            "Grapes are jam-packed with nutrients like vitamin C, vitamin K and powerful antioxidants that may improve your health in numerous ways."))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            melon,
            "Melon",
            "108",
            "• Calories: 64\n" +
                    "• Carbs: 16 grams\n" +
                    "• Fiber: 1.4 grams\n" +
                    "• Vitamin C: 53% of the reference daily intake (RDI)\n" +
                    "• Vitamin B6: 8% of the RDI\n" +
                    "• Vitamin K: 6% of the RDI",
            "They are a good source of dietary fiber, vitamin K, potassium, and copper, and a" +
                    " very good source of vitamin C and vitamin B6. Listed below are a few of the most common summer melons," +
                    " along with nutrition facts for each!"))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            multiFruit,
            "MultiFruit",
            "85",
            "• Vitamin B1: t0.083 mg 7.5% RDA\n" +
                    "• Vitamin B3: t1.2 mg 7.5% RDA\n" +
                    "• Vitamin B5: t0.45 mg 7.5% RDA\n" +
                    "• Vitamin B6: t0.105 mg 7.5% RDA\n" +
                    "• Vitamin B8: t3.75 µg 7.5% RDA\n" +
                    "• Vitamin K: 6% of the RDI",
            "They are a good source of dietary fiber, vitamin K, potassium, and copper, and a" +
                    " very good source of vitamin C and vitamin B6. Listed below are a few of the most common summer melons," +
                    " along with nutrition facts for each!"))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            nectarines,
            "Nectarines",
            "68",
            "• Calories: 63\n" +
                    "• Fat: 0.5 grams\n" +
                    "• Carbs: 15 grams\n" +
                    "• Protein: 1.5 grams\n" +
                    "• Fiber: 2.4 grams\n" +
                    "• Vitamin C: 8.5% of the DV",
            "In fact, a recent study in 800 adults with COVID-19 showed that taking 16, 200-mg doses of vitamin C decreased both ventilator dependence and death rates." +
                    " Other research also suggests reduced hospital stays and lower symptom severity "))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            oranges,
            "Oranges",
            "57,32",
            "• Calories: 66\n" +
                    "• Fat: 0.2 grams\n" +
                    "• Carbs: 14.8 grams\n" +
                    "• Protein: 1.3 grams\n" +
                    "• Fiber: 2.8 grams\n" +
                    "• Vitamin C: 92% of the Daily Value (DV)",
            "Helps your body make collagen, a protein that heals wounds and gives you smoother skin\n" +
                    "Makes it easier to absorb iron to fight anemia"))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            peaches,
            "Peaches",
            "67,87",
            "• Calories: 58\n" +
                    "• Fat: less than gram\n" +
                    "• Carbs: 14 grams\n" +
                    "• Protein: 1 grams\n" +
                    "• Fiber: 2 grams\n" +
                    "• Vitamin C: 17% of the Daily Value (DV)",
            "Peaches are a moderate source of beta carotene, a red-orange pigment found in fruits,” Smith says. The body turns beta carotene into vitamin A, an essential vitamin that’s important for healthy vision"))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            pumpkin,
            "Pumpkin",
            "43,6",
            "• Calories: 58\n" +
                    "• Fat: less than gram\n" +
                    "• Carbs: 14 grams\n" +
                    "• Protein: 1 grams\n" +
                    "• Fiber: 2 grams\n" +
                    "• Vitamin C: 17% of the Daily Value (DV)",
            "Your body changes this antioxidant to vitamin A. You need vitamin A to see, ward off germs, and for your reproductive system to work the way it should. " +
                    "It also helps your heart, lungs, kidneys, and other organs stay healthy."
        ))
        //*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            strawberry,
            "Strawberry",
            "87,9",
            "• Calories: 53\n" +
                    "• protein: 1.11 g\n" +
                    "• dietary fiber: 3.30 g\n" +
                    "• iron: 0.68 mg\n" +
                    "• magnesium: 22 mg\n" +
                    "• folate: 40 micrograms",
            "The heart-shaped silhouette of the strawberry is the first clue that this fruit is good for you. These potent little packages protect your heart, " +
                    "increase HDL (good) cholesterol, lower your blood pressure, and guard against cancer."
        ))
        //*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            tropicano,
            "Tropicano",
            "47",
            "• Vitamin C 276mg\n" +
                    "• Calcium 20mg\n" +
                    "• Potassium450mgg\n" +
                    "• Vitamin B6",
            " Vitamin C might be the most well-known of the bunch, but there are plenty of other minerals and vitamins in orange juice. " +
                    "Below is a list of some common nutrients," +
                    " minerals, and vitamins in orange juice, as well as how each functions in your body.  "
        ))
//*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*/*//*/*/*/*/*/*/*//*/*
        fruitList.add(FruitsData(unlike,
            water_mealons,
            "Water mealons",
            "76",
            "• 12 grams of carbohydrates\n" +
                    "• 12 milligrams of vitamin C\n" +
                    "• 170 milligrams of potassium\n" +
                    "• 0.1 milligrams of vitamin B6",
            "Body temperature regulation, normal organ function, nutrient delivery to cells, and alertness are only some of the bodily processes that rely on adequate hydration (2Trusted Source)." +
                    "Eating foods with a high water content may help give your body the water it needs to function properly." +
                    "Watermelon comprises 92% water, making it a great choice for daily water intake (3Trusted Source)."
        ))

        setCategoryRecycle(searchList)
        searchList.addAll(fruitList)


//
//
//        navView.setNavigationItemSelectedListener {
//            when (it.itemId){
//                R.id.all_items ->
//                else -> {
//                    false
//                }
//            }
//        }


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setCategoryRecycle(fruits: MutableList<FruitsData>) {
        adapter = FruitAdapter(fruits, this)
        binding.recycle?.layoutManager =
            StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        binding.recycle?.setHasFixedSize(true)
        binding.recycle?.adapter = adapter
        adapter?.notifyDataSetChanged()

    }

    override fun fonlikeClick(position: Int) {

//        for (i in searchList) {
//            if (i.likeImage == searchList[position].likeImage) {
//                if (!searchList[position].isClicked) {
//                    searchList[position].likeImage = like
//                    searchList[position].isClicked = true
//                        adapter?.notifyDataSetChanged()
//                } else {
//                    searchList[position].isClicked = false
//                    searchList[position].likeImage = unlike
//                    adapter?.notifyDataSetChanged()
//
//                }
//            }
//        }
    }


}

