//import io.reactivex.Observable
//import io.reactivex.functions.BiFunction
//import io.reactivex.rxkotlin.zipWith
//import java.util.concurrent.TimeUnit
//import kotlin.random.Random
//
//fun main() {
////    Observable.create<String> {emitter ->
////        // Hello 전달
////        emitter.onNext("Hello")
////        //World 전달
////        emitter.onNext("World")
////        //완료
////        emitter.onComplete()
////    }.subscribe { println(it) } //subscribe를 하는 순간에 위 블락의 코드를 탄다.(onclick을 호출하는 순간에 실행하느 것처럼)
//
//    //defer is case에 따라서 다른 observable을 받아야 할 상황 이 있을때
////    val observable = Observable.defer {
////        Observable.create<Int> {
////            println("생산")
////            it.onNext(1)
////        }
////    }
////    observable.subscribe { println(it) }
////    observable.subscribe { println(it) }
//
//
//    //fromArray
////    val items = arrayOf("Hello", "World")
////    Observable.fromArray(*items)   //* spread 연산자
////        .subscribe{ println(it) }
//
//    //4. fromCallable
////    println("start: ${System.currentTimeMillis()}")
////    fun createItem(): String {
////        println("create: ${System.currentTimeMillis()}")
////        return "HelloWorld"
////    }
////
////    val observable = Observable.fromCallable {  }
////    Thread.sleep(1000)
////    observable.subscribe{println(it)}
////    Thread.sleep(1000)
////    observable.subscribe{println(it)}
//
//
//    //5 fromIterable
//
//    //6. interval
////    Observable.interval(1000, 1000, TimeUnit.MILLISECONDS)
////        .subscribe{ println(it) }
////    Thread.sleep(5400)
//
//
//    //7. just
//
//    //8. range
////    Observable.range(8,10 )
////        .subscribe{ println(it) }
//
//    //8. repeat
////    val observable = Observable.just("Hello", "World")
////        .doOnSubscribe { println(it) }  //subscribe 되기전에(doon~는 ~이벤트 전에 실행되는 함수라는 소리 (doAfter도 있다.)
////        .repeat(2)
////    observable.subscribe{ println(it) }
//
//
//    //9. timer
////    println("start\t\t: ${System.currentTimeMillis()}")
////    Observable.timer(1000, TimeUnit.MILLISECONDS)
////        .subscribe { println("subscribe:\t ${System.currentTimeMillis()}") }
////    Thread.sleep(2000)
//
//
//
//    //Transforming Operator
//
//    //buffer(skipp coujnt는 따로 안줘도 된다. ㅇ안하면 디폴트로 )   뒤로가기 버튼 2번 눌러야 넘어가는 화면 구현할 떄
////    Observable.fromIterable(0..49)
////        .buffer(2,3)
////        .subscribe { println(it) }
//
//
//    //flatMap
////    Observable.just(1,2,3)
////        .flatMap { Observable.just("${it}") }
////        .subscribe{ println() } //여기 다 못침
//    //concatmap - flatmap과는 달리 sequence하게 앞에 들어온 애가 오래잡고 있다면 본인도 열심히 한다.
//    //switchmap (위 2개와 비교해라)
//
//
//
//    //map
////    Observable.fromIterable(0..3)
////        .map { "RXJava: $it"}
////        .subscribe{ println(it) }
//
//
//    //scan
////    Observable.fromIterable(0..3)
////        .scan { t1:Int, t2: Int ->  t1 + t2}
////        .subscribe{println(it)}
//
//
//
//
//
//
//    //20200726 일 4주차
////    Observable.interval(250, TimeUnit.MILLISECONDS)
////            .debounce(200, TimeUnit.MILLISECONDS)
//
//    //distinct
////    Observable.just(1,1,2,1,2,3)
////            .distinct()
////            .subscribe { println(it) }
////
//
//
//    //distinctUntilChanged
////    Observable.just(1, 1, 1, 2 ,1,  3)
////            .distinctUntilChanged()
////            .subscribe{ println(it) }
//
//    //filter
////    Observable.just(1, 1, 2, 1, 2, 3)
////            .filter {it % 2 == 1}
////            .subscribe { println(it) }
//
//
////    //ofType - 필터링과 타입 캐스팅이 동시에(rx bus 만들때 써봤다.)
////    Observable.just(1, true, "Hello", "World", 2f)
////            .ofType(Integer::class.java)
////            .subscribe { println(it) }
////
////    //위와 동일
////    Observable.just(1, "Hello")
////            .filter()
////            .cast
//
////    //ignoreElements
////    Observable.just(1, 1, 2, 1, 2, 3)
////            .ignoreElements()
////            .subscribe { println("complete") }
//
////    //throttleFirst(버튼을 일정시간 안에 또 누르면 안되게)
////    println(System.currentTimeMillis())
////    val observable = Observable.interval(100, TimeUnit.MILLISECONDS)
////            .throttleFirst(250, TimeUnit.MILLISECONDS)
////    observable.subscribe {
////        println(System.currentTimeMillis())
////        println(it)
////    }
////
////    Thread.sleep(1000)
//
//
////    //throttleLast(경계값은 timing에 따라 다름 - timing issue)
////    println(System.currentTimeMillis())
////    val observable = Observable.interval(0,100, TimeUnit.MILLISECONDS)
////            .throttleLast(250, TimeUnit.MILLISECONDS)
////    observable.subscribe {
////        println(System.currentTimeMillis())
////        println(it)
////    }
////    Thread.sleep(1000)
//
////    //skip/ skipLast
////    Observable.just(1, 1, 2, 1, 2, 3)
////            //.skip(2)
////            .skipLast(5) //complete이 되야 가능!
////            .subscribe { println(it) }
//
////    //take/takeLst
////    Observable.just(1,1,2,1,2,3)
////            .take(2)  //take(1) 은 Single과 같은데 사용함수만 다르다고 보면된다.
////       //     .takeLast(2)
////            .subscribe { println(it) }
//
//
//
//    //Combining Operator
//
////    //combineLastest
////    val observable1 = Observable.interval(1000L, TimeUnit.MILLISECONDS)
////    val observable2 = Observable.interval(750L, TimeUnit.MILLISECONDS).map { Random.nextInt(10) }
////    val observable = Observable.combineLatest<Long, Int, String>(
////            observable1,
////            observable2,
////            BiFunction<Long, Int, String> { t1, t2 ->
////                "$t1 $t2"
////            }) //3번째는 return type
////    observable.subscribe {
////        println(System.currentTimeMillis())
////        println(it)
////    }
////    Thread.sleep(3000)
//
////    //merge
////    val observable1 = Observable.interval(0, 1000L, TimeUnit.MILLISECONDS).map {"1:$it"}
////    val observable2 = Observable.interval(0, 500L, TimeUnit.MILLISECONDS).map { "2:$it" }.mergeWith(observable1)
////            .subscribe {
////                println(System.currentTimeMillis())
////                println(it)
////            }
////    //val observable = Observable.merge(observable1, observable2)
////
//////    observable.subscribe {
//////        println(System.currentTimeMillis())
//////        println(it)
//////    }
////    Thread.sleep(3000)
//
////    //startWith
////    Observable.just(1, 2, 3, 4, 5)
////            .startWith(100)
////            .subscribe { println(it) }
//
////    //zip
////    val observable1 = Observable.just(1,2,3,4,5)
////    val observable2 = Observable.just("a","b","c", "d", "e")
////            .zipWith(observable1, BiFunction<String, Int, String> {t1, t2 ->
////                "$t1 $t2"
////            } )
////            .subscribe { println(it) }
////
////    //이건 rx kotlin zip
////    Observable.just(1, 2)
////            .zipWith(Observable.just("a", "b")) {
////                Pair
////            }
//
////    //delay
////    println(System.currentTimeMillis())
////    Observable.just("Hello world")
////            .delay(3000, TimeUnit.MILLISECONDS)
////            .subscribe {
////                println(System.currentTimeMillis())
////                println(it)
////            }
////    Thread.sleep(5000) //이거 없으면 걍 프로그램이 종료되버림.
//
////    //do(1:02:30 - retrofit 설명 예)
////    Observable.just("Hello", "World")
////            .doOnNext { println("doOnNext")}
////            .doOnSubscribe { println("doOnSubscribe")  }
////            .doAfterNext { println("doAfterNext") }
////            .doAfterTerminate { println("doAfterTerminate") } //에러가 나도 , 끝나도 둘 다 수행.
////            .doFinally { println("doFinally") }
////            .doOnComplete { println("doOnComplete") }
////            .doOnDispose { println("doOnDispose") }
////            .doOnEach { println("doOnEach") }
////            .doOnError { println("doOnError")}
////            .doOnTerminate { println("doOnTerminate") }
////            .subscribe { println("- $it") }
//
//    //observeOn / subscribeOn
//    //에제가 없음.
//
//    //timeout
//    Observable.just("Hello", "World")
//            .delay(3000L, TimeUnit.MILLISECONDS)
//            .timeout(2000L, TimeUnit.MILLISECONDS, Observable.just("Hi", "hello")) //세번째 인자 없으면 TimeoutException
//            .subscribe({
//                println(it)
//            }, {
//                it.printStackTrace()
//            })
//
//    Thread.sleep(4000)
//
//}