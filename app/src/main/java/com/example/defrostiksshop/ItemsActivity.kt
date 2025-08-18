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

        items.add(Item(1,"gloves", "Перчатки для чистки бананов", "Надоело пачкать руки, чистя бананы? Теперь вы можете есть бананы даже на деловой встрече!", "Специальные силиконовые перчатки с микрошипами для идеальной очистки банановой кожуры. Разработаны для тех, кто устал от липких пальцев и случайно повреждённой мякоти. Эргономичная форма обеспечивает удобный захват, а антибактериальное покрытие гарантирует гигиеничность. Минималистичный дизайн, легко моются. Для тех, кто ценит необычные решения обычных задач!", 9.99))
        items.add(Item(2,"psi", "Основы псионики", "Учебник от доктора псионических наук Коренькова Е.С. под редакцией Григорьева В.С.", "Основы псионики — фундаментальный труд о природе сознания и его роли в формировании неопределённости мира. Книга объединяет идеи психологии, философии и квантовой физики. Рассматриваются модели коллапса функции сознания, когнитивные флуктуации в REM-сне и при смерти, а также роль памяти как «якоря» реальности. Издание рассчитано на исследователей, студентов и всех, кто интересуется пограничными областями науки.", 69.69))
        items.add(Item(3,"qr", "QR-код на рикрол", "QR-код Рикролл-ловушка – идеальный розыгрыш для друзей!", "Обычный квадратный стикер с коварным QR-кодом, незаметно отправляющим ничего не подозревающих жертв прямиком в объятия Рика Эстли. Идеально для офисных войнушек - клейте на клавиатуры коллег, мониторы начальства или даже на ценники в супермаркете. Матовая бумага не привлекает внимания, зато после отклеивания не оставляет улик. В упаковке 10 штук - хватит, чтобы устроить эпидемию рикролла по всему офису. Особо хитрые покупатели заказывают несколько пачек и устраивают тотальную засадку, размещая коды везде - от двери туалета до доски объявлений.", 42.99))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}