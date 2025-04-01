package com.example.e_book;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class booksFragment extends Fragment {
    RecyclerView rv;
    ArrayList<Book> booklist;
    public booksFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_books, container, false);

        rv=view.findViewById(R.id.rv1);

        rv.setLayoutManager(new GridLayoutManager(getContext(),2));

        Bundle bundle=getArguments();
        String genre=bundle.getString("genre");
        if(genre.equals("Mystery")){
            fillListMystery();
        }
        else if(genre.equals("Romance")){
            fillListRomance();
        }
        else if(genre.equals("Fantasy")){
            fillListFantasy();
        }
        else if(genre.equals("Comics")){
            fillListComics();
        }

        BookAdapter adapter= new BookAdapter(getActivity(),R.layout.books_recyclerview,booklist);
        rv.setAdapter(adapter);


        return view;
    }

    private void fillListComics() {
        booklist=new ArrayList<Book>();
        booklist.add(new Book("دوست خانواده",R.drawable.dostekhanevade,"https://dorsafaham.com/%d8%af%d9%88%d8%b3%d8%aa%e2%80%8c%d8%ae%d8%a7%d9%86%d9%88%d8%a7%d8%af%d9%87-%d8%af%d8%a7%d8%b3%d8%aa%d8%a7%db%8c%d9%81%d8%b3%da%a9%db%8c-@lbookl.pdf"));
        booklist.add(new Book("داستان خرس های پاندا",R.drawable.dastanekhershayepanda,"https://dorsafaham.com/%d8%af%d8%a7%d8%b3%d8%aa%d8%a7%d9%86%e2%80%8c%d8%ae%d8%b1%d8%b3%e2%80%8c%d9%87%d8%a7%db%8c%e2%80%8c%d9%be%d8%a7%d9%86%d8%af%d8%a7-@lbookl.pdf\n"));
        booklist.add(new Book("ته کلاس ردیف آخر صندلی آخر",R.drawable.tahekelas,"https://dorsafaham.com/%d8%aa%d9%87%e2%80%8c%da%a9%d9%84%d8%a7%d8%b3%e2%80%8c%d8%b1%d8%af%db%8c%d9%81%e2%80%8c%d8%a2%d8%ae%d8%b1%d8%b5%d9%86%d8%af%d9%84%db%8c%e2%80%8c%d8%a2%d8%ae%d8%b1_%d9%84%d9%88%d8%a6%db%8c%d8%b3%e2%80%8c%d8%b3%da%a9%d8%b1_@lbookl.pdf"));
        booklist.add(new Book("مغازه جادویی",R.drawable.maghazejadooi,"https://dorsafaham.com/%d9%85%d8%ba%d8%a7%d8%b2%d9%87%e2%80%8c%db%8c%e2%80%8c%d8%ac%d8%a7%d8%af%d9%88%db%8c%db%8c-%d8%ac%db%8c%d9%85%d8%b2%d8%a2%d8%b1%d8%af%d9%88%d8%aa%db%8c-@lbookl.pdf"));
        booklist.add(new Book("الفبای فلسفه",R.drawable.alefbayefalsafe,"https://dorsafaham.com/%d8%a7%d9%84%d9%81%d8%a8%d8%a7%db%8c%20%d9%81%d9%84%d8%b3%d9%81%d9%87.pdf"));
        booklist.add(new Book("آرزو های بزرگ",R.drawable.arezuhayebozorg,"https://dorsafaham.com/%d8%a7%d9%93%d8%b1%d8%b2%d9%88%d9%87%d8%a7%db%8c%20%d8%a8%d8%b2%d8%b1%da%af-%da%86%d8%a7%d8%b1%d9%84%d8%b2%20%d8%af%db%8c%da%a9%d9%86%d8%b2-@lbookl.pdf"));
        booklist.add(new Book("عوارض جانبی",R.drawable.avarezejanebi,"https://dorsafaham.com/%d8%b9%d9%88%d8%a7%d8%b1%d8%b6%20%d8%ac%d8%a7%d9%86%d8%a8%db%8c-%d9%88%d9%88%d8%af%db%8c%20%d8%a2%d9%84%d9%86-@lbookl.pdf"));
        booklist.add(new Book("عشق و یک دروغ",R.drawable.eshghvayekdorogh,"https://dorsafaham.com/%d8%b9%d8%b4%d9%82%e2%80%8c%d9%88%db%8c%da%a9%e2%80%8c%d8%af%d8%b1%d9%88%d8%ba-%d9%85%d8%a7%d8%b1%da%af%d8%b1%db%8c%d8%aa%e2%80%8c%d9%88%d8%b3%d8%aa-@lbookl.pdf"));
        booklist.add(new Book("ضربان قلب حقیقت مطلق",R.drawable.zarabaneghalbhaghighatemotlagh,"https://dorsafaham.com/%d8%b6%d8%b1%d8%a8%d8%a7%d9%86%e2%80%8c%d9%82%d9%84%d8%a8%e2%80%8c%d8%ad%d9%82%db%8c%d9%82%d8%aa%e2%80%8c%d9%85%d8%b7%d9%84%d9%82-%d8%a7%d8%b4%d9%88-@lbookl.pdf"));
        booklist.add(new Book("شهر فرنگ",R.drawable.shahrefarang,"https://dorsafaham.com/%d8%b4%d9%87%d8%b1%d9%81%d8%b1%d9%86%da%af-%d8%af%d8%a7%d9%86%db%8c%d9%84%e2%80%8c%d8%a7%d8%b3%d8%aa%db%8c%d9%84-@lbookl.pdf"));
        booklist.add(new Book("سکس و دموکراسی",R.drawable.sexvademokrasi,"https://dorsafaham.com/%d8%b3%da%a9%d8%b3%e2%80%8c%d9%88%d8%af%d9%85%d9%88%da%a9%d8%b1%d8%a7%d8%b3%db%8c-%d8%a7%da%a9%d8%a8%d8%b1%da%a9%d8%b1%d9%85%db%8c-@lbookl.pdf\n"));
        booklist.add(new Book("سکس شناسی",R.drawable.sexshenasi,"https://dorsafaham.com/%d8%b3%da%a9%d8%b3%20%d8%b4%d9%86%d8%a7%d8%b3%db%8c.pdf"));
        booklist.add(new Book("ساعت نحس",R.drawable.saatenahs,"https://dorsafaham.com/%d8%b3%d8%a7%d8%b9%d8%aa%e2%80%8c%d9%86%d8%ad%d8%b3_%da%af%d8%a7%d8%a8%d8%b1%db%8c%d9%84%e2%80%8c%da%af%d8%a7%d8%b1%d8%b3%db%8c%d8%a7%e2%80%8c%d9%85%d8%a7%d8%b1%da%a9%d8%b2_@lbookl.pdf"));

    }

    private void fillListFantasy() {
        booklist=new ArrayList<Book>();
        booklist.add(new Book("ژرفنا",R.drawable.zherfna,"https://dorsafaham.com/%da%98%d8%b1%d9%81%d9%86%d8%a7-%d8%ac%d9%88%d8%ac%e2%80%8c%d8%a7%d9%88%d8%b1%d9%88%d9%84-@lbookl.pdf\n"));
        booklist.add(new Book("پدر پولدار پدر بی پول",R.drawable.pedarbipool,"https://dorsafaham.com/%d9%be%d8%af%d8%b1%e2%80%8c%d9%be%d9%88%d9%84%d8%af%d8%a7%d8%b1%e2%80%8c%d9%be%d8%af%d8%b1%e2%80%8c%d8%a8%db%8c%e2%80%8c%d9%be%d9%88%d9%84_%d8%b1%d8%a7%d8%a8%d8%b1%d8%aa%e2%80%8c%da%a9%db%8c%d9%88%d8%b3%d8%a7%da%a9%db%8c_@lbookl.pdf"));
        booklist.add(new Book("وقتی زنان بخواهند",R.drawable.vaghtizananbekhahand,"https://dorsafaham.com/%d9%88%d9%82%d8%aa%db%8c%e2%80%8c%d8%b2%d9%86%d8%a7%d9%86%e2%80%8c%d8%a8%d8%ae%d9%88%d8%a7%d9%87%d9%86%d8%af_%da%af%d8%b1%db%8c%d8%b3%e2%80%8c%d8%a8%d8%a7%d9%86%db%8c_@lbookl.pdf\n"));
        booklist.add(new Book("نفر هفتم",R.drawable.nafarhaftom,"https://dorsafaham.com/%d9%86%d9%81%d8%b1%d9%87%d9%81%d8%aa%d9%85-%d9%87%d8%a7%d8%b1%d9%88%da%a9%db%8c%e2%80%8c%d9%85%d9%88%d8%b1%d8%a7%da%a9%d8%a7%d9%85%db%8c-@lbookl.pdf"));
        booklist.add(new Book("نسل عاشقان",R.drawable.nasleasheghan,"https://dorsafaham.com/%d9%86%d8%b3%d9%84%20%d8%b9%d8%a7%d8%b4%d9%82%d8%a7%d9%86-%d8%b1.%d8%a7%d8%b9%d8%aa%d9%85%d8%a7%d8%af%db%8c-@lbookl.pdf"));
        booklist.add(new Book("ملت عشق",R.drawable.melateeshgh,"https://dorsafaham.com/%d9%85%d9%84%d8%aa%20%d8%b9%d8%b4%d9%82-%d8%a7%d9%84%db%8c%d9%81%20%d8%b4%d8%a7%d9%81%d8%a7%da%a9-@lbookl.pdf"));
        booklist.add(new Book("ماورای طبیعی شدن",R.drawable.mavarayrtabieshodan,"https://dorsafaham.com/%d9%85%d8%a7%d9%88%d8%b1%d8%a7%db%8c%e2%80%8c%d8%b7%d8%a8%db%8c%d8%b9%db%8c%e2%80%8c%d8%b4%d8%af%d9%86_%d8%ac%d9%88%d8%af%db%8c%d8%b3%d9%be%d9%86%d8%b2%d8%a7_@lbookl.pdf"));
        booklist.add(new Book("بادام",R.drawable.badam,"https://dorsafaham.com/Almond.pdf"));
        booklist.add(new Book("گزارش یک آدم ربایی",R.drawable.gozareshyekadamrobai,"https://dorsafaham.com/%da%af%d8%b2%d8%a7%d8%b1%d8%b4%20%db%8c%da%a9%20%d8%a2%d8%af%d9%85%20%d8%b1%d8%a8%d8%a7%db%8c%db%8c.pdf"));
        booklist.add(new Book("موزه بی گناهی",R.drawable.mozebigonahi,"https://dorsafaham.com/%d9%85%d9%88%d8%b2%d9%87%d9%94%e2%80%8c%d8%a8%db%8c%e2%80%8c%da%af%d9%86%d8%a7%d9%87%db%8c_%d8%a7%d9%88%d8%b1%d9%87%d8%a7%d9%86%e2%80%8c%d9%be%d8%a7%d9%85%d9%88%da%a9_@lbookl.pdf\n"));
        booklist.add(new Book("من او را دوست داشتم",R.drawable.manooradostdashtam,"https://dorsafaham.com/%d9%85%d9%86%e2%80%8c%d8%a7%d9%88%e2%80%8c%d8%b1%d8%a7%d8%af%d9%88%d8%b3%d8%aa%e2%80%8c%d8%af%d8%a7%d8%b4%d8%aa%d9%85_%d8%a2%d9%86%d8%a7%da%af%d8%a7%d9%88%d8%a7%d9%84%d8%af%d8%a7_@lbookl.pdf"));

    }

    private void fillListRomance() {
        booklist=new ArrayList<Book>();
        booklist.add(new Book("خروج اضطراری",R.drawable.khorojezterari,"https://dorsafaham.com/%d8%ae%d8%b1%d9%88%d8%ac%e2%80%8c%d8%a7%d8%b6%d8%b7%d8%b1%d8%a7%d8%b1%db%8c_%d8%a7%db%8c%d9%86%db%8c%d8%a7%d8%aa%d8%b3%db%8c%d9%88%d8%b3%db%8c%d9%84%d9%88%d9%86%d9%87_@lbookl.pdf\n"));
        booklist.add(new Book("خودشناسی به روش یونگ",R.drawable.khodshenasi,"https://dorsafaham.com/%d8%ae%d9%88%d8%af%d8%b4%d9%86%d8%a7%d8%b3%db%8c%e2%80%8c%d8%a8%d9%87%e2%80%8c%d8%b1%d9%88%d8%b4%e2%80%8c%db%8c%d9%88%d9%86%da%af_%d9%85%d8%a7%db%8c%da%a9%d9%84%e2%80%8c%d8%af%d8%a7%d9%86%db%8c%d9%84%d8%b2_@lbookl.pdf\n"));
        booklist.add(new Book("خوشبخت مردن یا مرگ خاموش",R.drawable.margekhamosh,"https://dorsafaham.com/%d8%ae%d9%88%d8%b4%d8%a8%d8%ae%d8%aa%e2%80%8c%d9%85%d8%b1%d8%af%d9%86-%d8%a2%d9%84%d8%a8%d8%b1%da%a9%d8%a7%d9%85%d9%88-@lbookl.pdf"));
        booklist.add(new Book("دختری که رهایش کردی",R.drawable.thegirlyouleftbehind,"https://dorsafaham.com/%d8%af%d8%ae%d8%aa%d8%b1%db%8c%e2%80%8c%da%a9%d9%87%e2%80%8c%d8%b1%d9%87%d8%a7%db%8c%d8%b4%e2%80%8c%da%a9%d8%b1%d8%af%db%8c_%d8%ac%d9%88%d8%ac%d9%88%d9%85%d9%88%db%8c%d8%b2_@lbookl.pdf"));
        booklist.add(new Book("دنیای سوفی",R.drawable.sophiesworld,"https://dorsafaham.com/%d8%af%d9%86%db%8c%d8%a7%db%8c%20%d8%b3%d9%88%d9%81%db%8c.pdf\n"));
        booklist.add(new Book("ساعت ها",R.drawable.theclocks,"https://dorsafaham.com/%d8%b3%d8%a7%d8%b9%d8%aa%e2%80%8c%d9%87%d8%a7-%d8%a2%da%af%d8%a7%d8%aa%d8%a7%da%a9%d8%b1%db%8c%d8%b3%d8%aa%db%8c-@lbookl.pdf"));
        booklist.add(new Book("شاهنامه",R.drawable.shahname,"https://dorsafaham.com/%d8%b4%d8%a7%d9%87%d9%86%d8%a7%d9%85%d9%87%e2%80%8c%d9%81%d8%b1%d8%af%d9%88%d8%b3%db%8c-@lbookl.pdf\n"));
        booklist.add(new Book("صبح جادویی",R.drawable.themiraclemorning,"https://dorsafaham.com/%d8%b5%d8%a8%d8%ad%e2%80%8c%d8%ac%d8%a7%d8%af%d9%88%db%8c%db%8c-%d9%87%d8%a7%d9%84%e2%80%8c%d8%a7%d9%84%d8%b1%d9%88%d8%af-@lbookl.pdf"));
        booklist.add(new Book("عصر ادم کش ها",R.drawable.asreadamkoshha,"https://dorsafaham.com/%d8%b9%d8%b5%d8%b1%e2%80%8c%d8%a2%d8%af%d9%85%da%a9%d8%b4%e2%80%8c%d9%87%d8%a7-%d9%87%d9%86%d8%b1%db%8c%e2%80%8c%d9%85%db%8c%d9%84%d8%b1-@lbookl.pdf"));
        booklist.add(new Book("فعلا خوبم",R.drawable.felankhubam,"https://dorsafaham.com/%d9%81%d8%b9%d9%84%d8%a7%d8%ae%d9%88%d8%a8%d9%85_%da%af%d8%b1%db%8c%e2%80%8c%d8%af%db%8c%e2%80%8c%d8%a7%d8%b4%d9%85%db%8c%d8%aa-@lbookl.pdf\n"));
        booklist.add(new Book("قدرت بیان",R.drawable.ghodratbayan,"https://dorsafaham.com/%d9%82%d8%af%d8%b1%d8%aa%e2%80%8c%d8%a8%db%8c%d8%a7%d9%86-%d8%a8%d8%b1%d8%a7%db%8c%d8%a7%d9%86%e2%80%8c%d8%aa%d8%b1%db%8c%d8%b3%db%8c-@lbookl.pdf"));
        booklist.add(new Book("مادری که کم داشتم",R.drawable.madarikekamdashtam,"https://dorsafaham.com/%d9%85%d8%a7%d8%af%d8%b1%db%8c%e2%80%8c%da%a9%d9%87%e2%80%8c%da%a9%d9%85%e2%80%8c%d8%af%d8%a7%d8%b4%d8%aa%d9%85_%d8%ac%d8%a7%d8%b3%d9%85%db%8c%d9%86%e2%80%8c%d9%84%db%8c%e2%80%8c%da%a9%d9%88%d8%b1%db%8c_@lbookl.pdf"));

    }


    private void fillListMystery() {
        booklist=new ArrayList<Book>();
        booklist.add(new Book("آخرین روز یک محکوم",R.drawable.thelastdayofacondemnedman,"https://dorsafaham.com/%d8%a2%d8%ae%d8%b1%db%8c%d9%86%e2%80%8c%d8%b1%d9%88%d8%b2%e2%80%8c%db%8c%da%a9%e2%80%8c%d9%85%d8%ad%da%a9%d9%88%d9%85_%d9%88%db%8c%da%a9%d8%aa%d9%88%d8%b1%e2%80%8c%d9%87%d9%88%da%af%d9%88.pdf"));
        booklist.add(new Book("آنشرلی با موهای قرمز",R.drawable.anesherly,"https://dorsafaham.com/%d8%a2%d9%86%e2%80%8c%d8%b4%d8%b1%d9%84%db%8c%e2%80%8c%d8%a8%d8%a7%e2%80%8c%d9%85%d9%88%d9%87%d8%a7%db%8c%e2%80%8c%d9%82%d8%b1%d9%85%d8%b2_%d9%85%d9%88%d9%86%d8%aa%da%af%d9%85%d8%b1%db%8c_@lbookl.pdf"));
        booklist.add(new Book("ابله",R.drawable.theidiot,"https://dorsafaham.com/%d8%a7%d8%a8%d9%84%d9%87-%d8%af%d8%a7%d8%b3%d8%aa%d8%a7%db%8c%d9%81%d8%b3%da%a9%db%8c-@lbookl.pdf"));
        booklist.add(new Book("اعتراف",R.drawable.aconfession,"https://dorsafaham.com/%d8%a7%d8%b9%d8%aa%d8%b1%d8%a7%d9%81%e2%80%8c%d9%85%d9%86-%d9%84%d8%a6%d9%88%d9%86%e2%80%8c%d8%aa%d9%88%d9%84%d8%b3%d8%aa%d9%88%db%8c-@lbookl.pdf"));
        booklist.add(new Book("انجمن شاعران مرده",R.drawable.deadpoetssociety,"https://dorsafaham.com/%d8%a7%d9%86%d8%ac%d9%85%d9%86%e2%80%8c%d8%b4%d8%a7%d8%b9%d8%b1%d8%a7%d9%86%e2%80%8c%d9%85%d8%b1%d8%af%d9%87_%e2%80%8c%da%a9%d9%84%d8%a7%db%8c%d9%86%e2%80%8c%d8%a8%d8%a7%d9%85_@lbookl.pdf"));
        booklist.add(new Book("جسد",R.drawable.thebodyinthelibrary,"https://dorsafaham.com/%d8%ac%d8%b3%d8%af-%d8%a2%da%af%d8%a7%d8%aa%d8%a7%da%a9%d8%b1%db%8c%d8%b3%d8%aa%db%8c-@lbookl.pdf"));
        booklist.add(new Book("حاجی اقا",R.drawable.hajiagha,"https://dorsafaham.com/%d8%ad%d8%a7%d8%ac%db%8c%e2%80%8c%d8%a2%d9%82%d8%a7-%d8%b5%d8%a7%d8%af%d9%82%e2%80%8c%d9%87%d8%af%d8%a7%db%8c%d8%aa-@lbookl.pdf"));
        booklist.add(new Book("The words I wish I said",R.drawable.thewordiwishisaid,"https://dorsafaham.com/%d8%ad%d8%b1%d9%81%e2%80%8c%d9%87%d8%a7%db%8c%db%8c%e2%80%8c%da%a9%d9%87%e2%80%8c%da%a9%d8%a7%d8%b4%e2%80%8c%d9%85%db%8c%e2%80%8c%d8%b2%d8%af%d9%85_%da%a9%db%8c%d8%aa%d9%84%db%8c%d9%86%e2%80%8c%da%a9%d9%84%db%8c_@lbookl.pdf"));
        booklist.add(new Book("حکمت شادان",R.drawable.thegayscience,"https://dorsafaham.com/%d8%ad%da%a9%d9%85%d8%aa%e2%80%8c%d8%b4%d8%a7%d8%af%d8%a7%d9%86-%d9%86%db%8c%da%86%d9%87-@lbookl.pdf\n"));
        booklist.add(new Book("خاطرات یک استاد",R.drawable.khateratyekostad,"https://dorsafaham.com/%d8%ae%d8%a7%d8%b7%d8%b1%d8%a7%d8%aa%e2%80%8c%db%8c%da%a9%e2%80%8c%d8%a7%d8%b3%d8%aa%d8%a7%d8%af_%d8%a2%d9%86%d8%aa%d9%88%d8%a7%d9%86%e2%80%8c%da%86%d8%ae%d9%88%d9%81_@lbookl.pdf\n"));
    }
}