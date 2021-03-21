# Android-2wayDataBinding
Sample app demonstrating use of ViewModel and two way DataBinding

In this example we are binding the activity's viewmodel itself into it's layout.

```
mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
mViewModel = ViewModelProvider(this, MainViewModelFactory(50)).get(MainActivityViewModel::class.java)

mBinding.vm = mViewModel
```

Our viewmodel has a livedata which can now be used directly from xml file
```
private var sum = MutableLiveData<Int>()

    fun updateSum() {
        sum.value = sum.value?.plus(input.toInt()) ?: 0
    }
```

Directly update livedata from xml file when user inputs data
```android:text="@={vm.input}"```

Directly call viewmodel's functions from xml
```
         <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="@{()->vm.updateSum()}"
            ...
```            

Hook the view contect to the livedata
```
        <TextView
            android:id="@+id/result"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@{`SUM: `+String.valueOf(vm.sumData)}"
```

Make sure to add ```mBinding.lifecycleOwner = this``` to enable the livedata updates in your layout.
