# kotlin_annotation
演示kotlin注解和反射的使用
实现了findviewbyid 和 onclick 功能

使用方法如下：
```kotlin

class MainActivity : AppCompatActivity() {

    @FindView(R.id.tv)
    private lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewUtils.inject(this)
        text.setText("hello")
    }
    @Onclick([R.id.tv,R.id.test])
    fun hello(view: View){
        when(view.id){
            R.id.tv -> Toast.makeText(this,"hello",Toast.LENGTH_LONG).show()
            R.id.test -> Toast.makeText(this,"world",Toast.LENGTH_LONG).show()
        }

    }
}

```
