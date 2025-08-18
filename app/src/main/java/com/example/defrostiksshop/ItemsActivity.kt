package com.example.defrostiksshop

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1,"gloves", "Перчатки для чистки бананов", "Надоело пачкать руки, чистя бананы? Теперь вы можете есть бананы даже на деловой встрече!", "Полное описание", 9.99))
        items.add(Item(2,"psi", "Основы псионики", "Учебник от доктора псионических наук Коренькова Е.С. под редакцией Григорьева В.С.", "Полное описание2", 69.69))
        items.add(Item(3,"qr", "QR-код на рикрол", "QR-код Рикролл-ловушка – идеальный розыгрыш для друзей!", "Полное описание3", 42.99))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}