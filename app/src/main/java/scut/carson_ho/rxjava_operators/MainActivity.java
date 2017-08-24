package scut.carson_ho.rxjava_operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;


public class MainActivity extends AppCompatActivity {

    private String TAG = "RxJava";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Observable.just(1,2,3,4,5,6)
//                .map(new Function<Integer,String>() {
//                    @Override
//                    public String apply(Integer value) throws Exception {
//                        File file = new File(value);
//                        file.createNewFile();
//                        return "aa";
//                    }
//                });





        Observable.just(1,2,3,4,5,6)
                .all(new Predicate<Integer>(){
                    @Override
                    public boolean test( Integer integer) throws Exception {
                        return (integer<=10);
                        // 该函数用于判断Observable发送的10个数据是否都满足integer<=10
                    }
                }).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                Log.d(TAG,"result is "+ aBoolean);
                // 输出返回结果
            }

        });

//        Observable.just(1,2,3,4,5,6)
//                .all(new Func2<Integer, Boolean>() {
//                    @Override
//                    public Boolean apply(Integer integer, @NonNull Object o2) throws Exception {
//                        return integer<=10;
//                        // 该函数用于判断Observable发送的10个数据是否都满足integer<=10
//                    }
//
//                    @Override
//                    public Boolean call(Integer integer) {
//                        return integer<=10;
//                        // 该函数用于判断Observable发送的10个数据是否都满足integer<=10
//                    }
//                }).subscribe(new Consumer<Boolean>() {
//            @Override
//            public void accept(Boolean aBoolean) throws Exception {
//                Log.d(TAG,"result is "+ aBoolean);
//                // 输出返回结果
//            }
//
//        });

//        Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                  // 不发送任何有效事件
//                  // subscriber.onNext(1);
//                  // subscriber.onNext(2);
//                  // subscriber.onNext(3);
//
//                subscriber.onCompleted();
//                // 仅发送Complete事件
//            }
//        }).defaultIfEmpty(10) // 若仅发送了Complete事件，默认发送 值 = 10
//                .subscribe(new Subscriber<Integer>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.v(TAG, "onCompleted");
//                    }
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.v(TAG, "onError:"+e.getMessage());
//                    }
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.v(TAG, "onNext:"+integer);
//                    }
//                });

//
//// 1. 通过creat（）创建被观察者对象
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            // 2. 在复写的subscribe（）里定义需要发送的事件
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onNext(4);
//
//                emitter.onComplete();
//            }  // 至此，一个被观察者对象（Observable）就创建完毕
//        }).subscribe(new Observer<Integer>() {
//            // 以下步骤仅为展示一个完整demo，可以忽略
//            // 3. 通过通过订阅（subscribe）连接观察者和被观察者
//            // 4. 创建观察者 & 定义响应事件的行为
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "开始采用subscribe连接");
//            }
//            // 默认最先调用复写的 onSubscribe（）
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "接收到了事件"+ value  );
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "对Error事件作出响应");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "对Complete事件作出响应");
//            }
//
//        });
    }

    }


