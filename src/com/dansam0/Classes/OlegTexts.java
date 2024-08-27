package com.dansam0.Classes;

import java.util.ArrayList;
import java.util.List;

public class OlegTexts {

    private List<String> texts = new ArrayList<>();


    public OlegTexts(){

        addOlegTexts("олежечка \uD83E\uDD75 \uD83E\uDD75 \uD83E\uDD75");
        addOlegTexts("олег \uD83E\uDD5A");
        addOlegTexts("банан в бэкенде");
        addOlegTexts("IT на жопе");
        addOlegTexts("олег");
        addOlegTexts("олегей \uD83E\uDD76 \uD83E\uDD76 ");
        addOlegTexts("oleg");
        addOlegTexts("лего");
        addOlegTexts("олежа");
        addOlegTexts("олёжка \uD83D\uDC4A\uD83C\uDFFB \uD83D\uDE18 \uD83E\uDDB6\uD83C\uDFFB ");
        addOlegTexts("антон 0_o");
        addOlegTexts("\uD83E\uDD5A");

    }

    public void addOlegTexts(String text) {
        texts.add(text);
    }

    @ReflectOleg()
    public String getOlegTexts(int index){
        return texts.get(index);
    }

    public int getOlegTextsSize(){
        return texts.size();
    }

}
