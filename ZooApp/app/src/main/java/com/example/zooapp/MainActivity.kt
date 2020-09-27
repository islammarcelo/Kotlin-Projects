package com.example.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var animalList = ArrayList<Animal>()
    var adapter:AnimalAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * Load Image
         */
        animalList.add(Animal("Baboon","This Animal Live In The Zoo Whit Animals",R.drawable.baboon,false))
        animalList.add(Animal("BullDog","This Animal Live In The Zoo Whit Animals",R.drawable.bulldog,false))
        animalList.add(Animal("Panda","This Animal Live In The Zoo Whit Animals",R.drawable.panda,true))
        animalList.add(Animal("Swallow","This Animal Live In The Zoo Whit Animals",R.drawable.swallow_bird,false))
        animalList.add(Animal("White Tiger","This Animal Live In The Zoo Whit Animals",R.drawable.white_tiger,true))
        animalList.add(Animal("Zebra","This Animal Live In The Zoo Whit Animals",R.drawable.zebra,false))
        animalList.add(Animal("Baboon","This Animal Live In The Zoo Whit Animals",R.drawable.baboon,false))
        animalList.add(Animal("BullDog","This Animal Live In The Zoo Whit Animals",R.drawable.bulldog,false))
        animalList.add(Animal("Panda","This Animal Live In The Zoo Whit Animals",R.drawable.panda,true))
        animalList.add(Animal("Swallow","This Animal Live In The Zoo Whit Animals",R.drawable.swallow_bird,false))
        animalList.add(Animal("White Tiger","This Animal Live In The Zoo Whit Animals",R.drawable.white_tiger,true))
        animalList.add(Animal("Zebra","This Animal Live In The Zoo Whit Animals",R.drawable.zebra,false))
        adapter = AnimalAdapter(animalList,this)
        animal_list.adapter = adapter
    }

    /***
     * For Delete Any Animal From ViewList by Click on image of animal
     */
    fun delete(index:Int){
        animalList.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }
    /***
     * For Add Any Animal From ViewList by Click on image of animal
     */
    fun add(index:Int){
        animalList.add(animalList[index])
        adapter!!.notifyDataSetChanged()
    }

    inner class AnimalAdapter:BaseAdapter{

        var listOfAnimal = ArrayList<Animal>()
        var context:Context?=null

        constructor(listOfAnimal: ArrayList<Animal>, context: Context?) : super() {
            this.listOfAnimal = listOfAnimal
            this.context = context
        }


        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            val animal = listOfAnimal[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView:View?=null
            if(animal.isKiller == true){
                myView = inflator.inflate(R.layout.animal_ticket_killer,null)
                return view(myView, animal, context!!,position)
            }else{
                myView = inflator.inflate(R.layout.animal_ticket,null)
                return view(myView, animal, context!!,position)
            }

        }

        private fun view(
            myView: View?,
            animal: Animal,
            context: Context,
            position: Int
        ): View? {
            myView?.animal_name!!.text = animal.name!!
            myView.animal_description.text = animal.des!!
            myView.animal_image.setImageResource(animal.image!!)
            myView.animal_image.setOnClickListener{
                val intent = Intent(context,AnimalDetialsActivity::class.java)
                intent.putExtra("name",animal.name!!)
                intent.putExtra("des",animal.des!!)
                intent.putExtra("image",animal.image!!)
                context!!.startActivity(intent)
            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return listOfAnimal[position]
        }

        override fun getItemId(position: Int): Long {
           return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimal.size
        }

    }
}
