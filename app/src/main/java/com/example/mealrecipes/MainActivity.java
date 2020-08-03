package com.example.mealrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Meal> mealList = new ArrayList<>();
    List<Meal> favoriteList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fillMealList(mealList); //fill list with data


        //Recyclerview Adapter
        final MealAdapter adapter = new MealAdapter(MainActivity.this, mealList);//указываем текущий активити чтобы связать с адаптером


        RecyclerView recyclerView;
        adapter.setOnItemClickListener(new MealAdapter.RecyclerOnClickListener() {

            @Override
            public void onItemClick(int position) {

                Intent intent = new Intent(MainActivity.this, Mealdetails.class);

                if (!mealList.isEmpty()) {
                    intent.putExtra("meal", (Serializable) mealList);
                    intent.putExtra("position", (int) position);
                }
                //   intent.putExtra("position", (int) position);
                startActivity(intent);
            }

            @Override
            public void onStarClick(int position) {
                //           favoriteList.add(mealList.get(position));
                mealList.get(position).setStarred(true);


            }


        });

        //Recyclerview config
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.favorite_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent intentFavorite = new Intent(MainActivity.this, Favorite.class);
                for (Meal meal : mealList) {
                    if (meal.isStarred()) {
                        favoriteList.add(meal);
                    }
                }

                if (!favoriteList.isEmpty()) {
                    intentFavorite.putExtra("favorite", (Serializable) favoriteList);
                    startActivity(intentFavorite);
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void fillMealList(List<Meal> mealList) {
        mealList.add(new Meal(R.drawable.schaschlik, "Schaschlik wie im Kaukasus grillen", "ein russisches Rezept, das sehr lecker und einfach zu machen ist.", "20 Minuten", "1 Tag", "1 Tag 20 Minuten", 4, "1 kg Fleisch (Nackenfleisch von Schwein, Rind oder Lamm), frisch\n" +
                "3 Gemüsezwiebel(n)\n" +
                "500 ml Milch\n" +
                "1 Schuss Essig\n" +
                "Salz und Pfeffer aus der Mühle\n" +
                "1 etwas Tomatenmark\n" +
                "1 Kiwi(s)", "Den Schweinenacken in nicht zu kleine Würfel schneiden. Die Zwiebeln halbieren und in halbe Ringe schneiden.\n" +
                "\n" +
                "Tomatenmark, Salz, Pfeffer und einen Spritzer Essig mischen und mit der Hand schön in das Fleisch einmassieren. Alles in eine große Schüssel geben und mit Milch auffüllen. Zugedeckt über Nacht an einem kühlen Ort einziehen lassen.\n" +
                "\n" +
                "Am nächsten Tag die Marinade probieren und evtl. mit Salz und Pfeffer nachwürzen. Ca. 2 Stunden vorm Grillen die Kiwi schälen und in kleine Stücke schneiden. In die Marinade geben und ebenfalls in das Fleisch einmassieren. Bitte die Kiwi nicht zu lange (max. 2 Stunden) in der Marinade lassen, da sonst das Fleisch zu weich wird und vom Spieß fällt.\n" +
                "\n" +
                "Dann das Fleisch auf Spieße ziehen und grillen. Kurz vor dem Verzehr mit Essigwasser beträufeln. Sehr lecker schmeckt auch, frische Zwiebelringe in leichtes Essigwasser einzulegen und zum Schaschlik servieren."));

        mealList.add(new Meal(R.drawable.damlama, "Usbekischer Eintopf Damlama", "auch als Dimlama oder Basma - im Kaukasus als Adzhab-Sandal bekannt", "30 Minuten", "2 Stunden", "2 Stunden 30 Minuten", 6, "100 ml Pflanzenöl\n" +
                "½ kg Lammfleisch\n" +
                "5 Zwiebel(n)\n" +
                "500 g Tomate(n)\n" +
                "200 g Karotte(n)\n" +
                "3 Kartoffel(n)\n" +
                "2 Paprikaschote(n)\n" +
                "1 Aubergine(n)\n" +
                "½ Weißkohl\n" +
                "5 Zehe/n Knoblauch\n" +
                "1 Bund Dill\n" +
                "1 Bund Koriandergrün\n" +
                "1 Bund Petersilie\n" +
                "1 TL Kreuzkümmel\n" +
                "2 Lorbeerblätter\n" +
                "2 Chilischote(n)\n" +
                "Salz und Pfeffer", "Das Lammfleisch in nicht zu kleine Würfel schneiden und mit einer gehackten Zwiebel im Öl anbraten. Salzen und pfeffern, Lorbeerblätter und Kreuzkümmel zugeben.\n" +
                "\n" +
                "Das Gemüse und die restlichen Zwiebeln in Scheiben schneiden. Sukzessive zunächst die Zwiebeln, dann die Karotten, den Paprika, die Tomaten- und die Auberginenscheiben auf das Fleisch schichten. Mit Weißkohlblättern abdecken und als nächstes die Kartoffelscheiben auflegen. Darauf die grob gehackten frischen Kräuter, die Knoblauchzehen und die beiden Chilischoten verteilen. Mit einer neuen Schicht Weißkohlblätter abschließen und den Topf möglichst dicht abdecken. Zunächst stark erhitzen bis die sich bildende Flüssigkeit hörbar aufkocht, dann auf die kleinste Stufe zurückschalten und alles in anderthalb bis zwei Stunden gar dünsten.\n" +
                "\n" +
                "Natürlich gibt es zahlreiche Zubereitungsvarianten. So können die Gemüse variiert oder auch Apfelscheiben oder Quitten zugegeben werden."));
        mealList.add(new Meal(R.drawable.russische_sommersuppe,"Russische Sommersuppe","Akroschka - das bedeutet Krümel oder ganz fein","30 Minuten","4 Stunden","5 Stunden",6,"6 große Kartoffel(n)\n" +
                "1 Ring/e Fleischwurst oder Geflügelwurst\n" +
                "6 Ei(er)\n" +
                "1 Bund Radieschen\n" +
                "1 Salatgurke(n)\n" +
                "1 Bund Schnittlauch oder Frühlingszwiebeln\n" +
                "1 Bund Dill\n" +
                "2 Becher Schmand\n" +
                "1 Becher saure Sahne, 200 g\n" +
                "2 EL Essig zum Abschmecken, evtl. mehr oder weniger\n" +
                "Salz und Pfeffer, schwarzer\n" +
                "2 Liter Wasser","Kartoffeln und Eier mit der Schale kochen, danach abkühlen lassen und schälen. Alle Zutaten in so feine Würfel wie nur möglich schneiden.\n" +
                "\n" +
                "Alles in einen Topf geben und mit dem Wasser, Schmand, saurer Sahne und den Gewürzen mischen, abschmecken und dann kühl stellen. Die Akroschka muss 2 - 4 Stunden ruhen. Sie kann auch über Nacht im Kühlschrank stehen bleiben.\n" +
                "\n" +
                "Dann wird sie einfach wie Suppe gegessen. Kühl - genau richtig für den Sommer."));
        mealList.add(new Meal(R.drawable.russischer_hackfleischtopf,"Russischer Hackfleischtopf","Russischer Hackfleischtopf","20 Minuten","25 Minuten"," 45 Minuten",4,"500 g Rinderhackfleisch\n" +
                "2 Zwiebel(n)\n" +
                "1 EL Öl\n" +
                "1 EL Butter\n" +
                "1 Porreestange(n)\n" +
                "5 EL Tomatenmark\n" +
                "250 ml Brühe\n" +
                "1 EL Senf\n" +
                "1 TL Paprikapulver, edelsüß\n" +
                "1 TL Salz\n" +
                "n. B. saure Sahne","Was an dem Gericht russisch sein soll, ist mir schleierhaft, aber es ist super einfach zu machen und schmeckt hervorragend.\n" +
                "\n" +
                "Zwiebeln schälen und würfeln, Lauch putzen, waschen und in Ringe schneiden. Öl und Butter in einem Topf erhitzen, die Zwiebelwürfel darin anbraten. Die Hitze erhöhen und das Hackfleisch darin krümelig braten. Bei jetzt wieder niedrigerer Hitze den Lauch, das Tomatenmark, die Brühe, Senf und die Gewürze dazugeben. Ca. 15 Minuten schmoren, dabei häufig umrühren. Die saure Sahne kurz vor dem Servieren unterrühren und alles nochmal kräftig abschmecken."));
        mealList.add(new Meal(R.drawable.kartoffelsalat,"Kartoffelsalat","gesamtdeutscher Kartoffelsalat, weil wenig Mayo und auch Brühe vorhanden sind. Anfängertaugliches Grundrezept.","30 Minuten","30 Minuten","3 Stunden",6,"2 kg Kartoffeln, festkochend\n" +
                "1 m.-große Zwiebel(n), feinst gewürfelt\n" +
                "250 ml Gemüsebrühe oder Geflügelbrühe\n" +
                "3 EL Weißweinessig, milder, z.B. Marc de Champagner Essig\n" +
                "2 EL Dijonsenf, mit grünem Pfeffer\n" +
                "200 g Mayonnaise, selbstgemacht oder wirklich gutes Fertigprodukt\n" +
                "6 kleine Gewürzgurke(n), fein geschnitten\n" +
                "etwas Gurkenflüssigkeit","Die Kartoffeln als Pellkartoffeln mit etwas Salz kochen, abgießen und pellen. Erkalten lassen und dann in dünne Scheiben schneiden, nicht hobeln, sonst werden die Scheiben zu dünn.\n" +
                "\n" +
                "Brühe aufkochen lassen und die fein gehackte Zwiebel etwa 2 - 3 Minuten darin kochen lassen, den Essig dazu geben. Von Herd nehmen und abkühlen lassen. Den Senf dann einschlagen. Die Brühe-Zwiebelmischung über die Kartoffelscheiben geben, unterrühren und etwas ziehen lassen. Die Gewürzgurken in kleine Würfel schneiden und auf die Masse geben. Die Mayo mit dem Gewürzgurkenwasser aufrühren und über den Salat geben, vorsichtig unterheben und ziehen lassen.\n" +
                "\n" +
                "Dies ist ein Grundrezept. Im Sommer mach ich das gerne mit getrockneten und dann eingelegten Tomaten,in Stückchen geschnitten), fein geschnittener Frühlingszwiebel, Radieschenscheiben oder auch Olivenstückchen. Geht auch prima mit Steak- oder Bratenresten, frischen Kräutern oder auch quer durch den Kühlschrank - etwas Paprika, Tomate, Gurkenstücke etc..\n" +
                "\n" +
                "Meine Fußballer mögen den einfach nur so zum Braten oder Schnitzel, aber der Salat lädt zum \"Spielen\" ein."));

    }
}