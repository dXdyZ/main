package com.example.programmn1.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

//будут трястись когда неправильно ввел данный
// Node - это любое обьект на окне
public class Shake {
    private TranslateTransition tt;

    public Shake(Node node){
        tt = new TranslateTransition(Duration.millis(70),node); // как долго будет идти анимация
        tt.setFromX(0f);
        tt.setByX(10f); // на сколько он передвинется
        tt.setCycleCount(3); // сколько раз будет двигаться
        tt.setAutoReverse(true);
    }

    // проигрывает анимацию
    public void playAnim(){
        tt.playFromStart(); //запукс анимации
    }
}
