//import io.reactivex.Observable
//import io.reactivex.Single
//import io.reactivex.disposables.CompositeDisposable
//import io.reactivex.disposables.Disposable
//import java.util.concurrent.TimeUnit
//
//typealias Observer<T> = (event: T) -> Unit
//class EventSource<T> {
//    private val observers = mutableListOf<Observer<T>>()
//    fun addObserver(observer: Observer<T>) {
//        observers += observer
//    }
//
//    fun notify(event: T) {
//        observers.forEach { it(event) }
//    }
//}
//
//fun main() {
////    val eventSource =  EventSource<String>()
////    eventSource.addObserver { println("첫 번째 옵저버 : $it") }
////    eventSource.addObserver { println("두 번째 옵저버 : $it") }
////    eventSource.notify("Hello")
////    eventSource.notify("Observer Pattern")
//
////    Observable.just(0,1,2,3)
////            .map {it * 2 }
////            .subscribe { println(it) }
//
////    val compositeDisposable = CompositeDisposable()
////    val disposable1 = Observable.just(1,2)
////            .subscribe { println(it) }
////
////    compositeDisposable.add(disposable1)
////    //compositeDisposable.clear() //dispose()
////    compositeDisposable.dispose()
////    val disposable2 = Observable.just(3,4)
////            .delay(1, TimeUnit.SECONDS)
////            .subscribe { println(it) }
////    compositeDisposable.add(disposable2)
////    Thread.sleep(2000L)
//
//    //과제 rx hello world
//    val observable = Observable.just("Hello world")
//            .subscribe { println(it) }
//
//}
//
