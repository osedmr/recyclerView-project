package com.osefe.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try{
            //veri tabanı oluştur
            val myDatabase=this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INT)")
          //veri yaz
         //  myDatabase.execSQL("INSERT INTO musicians(name,age)VALUES('Osman',22)")
          // myDatabase.execSQL("INSERT INTO musicians(name,age)VALUES('Demir',23)")
          // myDatabase.execSQL("INSERT INTO musicians(name,age)VALUES('mirkan',25)")
            //yukardakileri kaydettik şimdi güncelleme ve silme yapıcaz(kayıtlı diye iki çizki çektim)

           // myDatabase.execSQL("UPDATE musicians SET age=61 WHERE name='mirkan'")

            //veri silmek dikkatli ol
            myDatabase.execSQL("DELETE FROM musicians WHERE id=1")

            //veriyi çekmek için                              //Where ile istediğini çekebilirsin örnek id=3 çeker
            val cursor=myDatabase.rawQuery("SELECT * FROM musicians ",null)
             val nameIx=cursor.getColumnIndex("name")
            val  ageIx=cursor.getColumnIndex("age")
            val idIx=cursor.getColumnIndex("id")

            while (cursor.moveToNext()){
                println("name= ${cursor.getString(nameIx)}")
                println("age= ${cursor.getInt(ageIx)}")
                println("id=${cursor.getInt(idIx)}")
            }
            //işi bitince curser kapat
            cursor.close()

        }catch(e:Exception){
            e.printStackTrace()

        }
    }
}