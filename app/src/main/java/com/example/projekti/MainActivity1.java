package spartons.com.googlemapcustommarkercluster;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterManager;

import java.util.Arrays;
import java.util.List;

import spartons.com.googlemapcustommarkercluster.clusterRenderer.MarkerClusterRenderer;
import spartons.com.googlemapcustommarkercluster.data.User;
import spartons.com.googlemapcustommarkercluster.util.GoogleMapHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main);
        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapFragment);
        assert supportMapFragment != null;
        supportMapFragment.getMapAsync(googleMap -> {

            GoogleMapHelper.defaultMapSettings(googleMap);
            setUpClusterManager(googleMap);
        });
    }




    private void setUpClusterManager(GoogleMap googleMap) {
        ClusterManager<User> clusterManager = new ClusterManager<>(this, googleMap);

        MarkerClusterRenderer markerClusterRenderer = new MarkerClusterRenderer(this, googleMap, clusterManager);

        clusterManager.setRenderer(markerClusterRenderer);

        List<User> items = getItems();

        clusterManager.addItems(items);

        clusterManager.cluster();
    }

    private List<User> getItems() {
        return Arrays.asList(
                new User("Shpella e Gadimes", new LatLng(42.4780855, 21.207569), "https://sq.wikipedia.org/wiki/Shpella_e_Gadim%C3%ABs"),
                new User("Ujvara e Mirushes", new LatLng(42.5240,20.6003), "https://sq.wikipedia.org/wiki/Uj%C3%ABvarat_e_Mirush%C3%ABs"),
                new User("Gryka e Rugoves", new LatLng(42.6939, 20.1653), "https://sq.wikipedia.org/wiki/Gryka_e_Rugov%C3%ABs"),
                new User("Liqani i Ujmanit", new LatLng(42.9584, 20.5737), "https://sq.wikipedia.org/wiki/Liqeni_i_Ujmanit"),
                new User("Bjeshket e Nemuna", new LatLng(42.6234,20.1879), "https://en.wikipedia.org/wiki/Bjeshk%C3%ABt_e_Nemuna_National_Park"),
                new User("Malet e Sharrit", new LatLng(42.0833,20.8333), "https://sq.wikipedia.org/wiki/Bjeshk%C3%ABt_e_Sharrit"),
                new User("Prizeren", new LatLng(42.2171,20.7436), "https://en.wikipedia.org/wiki/Prizren"),
                new User("Bibloteka kombetare", new LatLng(42.6575,21.1622), "https://www.biblioteka-ks.org/"),
                new User("Ferizaj", new LatLng(42.3702,21.1483), "https://en.wikipedia.org/wiki/Ferizaj"),
                new User("Muzeu i Kosoves", new LatLng(42.6657,21.1659), "https://sq.wikipedia.org/wiki/Muzeu_i_Kosov%C3%ABs"),
                new User("Prekaz", new LatLng(42.7530,20.8054), "https://en.wikipedia.org/wiki/Prekaz")

        );
    }
}
