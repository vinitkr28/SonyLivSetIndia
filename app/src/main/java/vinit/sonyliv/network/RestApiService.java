package vinit.sonyliv.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import vinit.sonyliv.model.ProductWrapper;

public interface RestApiService {

    // For the time being Fk-Affiliate-Id, Fk-Affiliate-Token har corded here
    /*@Headers({
            "Accept: application/json",
            "Fk-Affiliate-Id: abcdefg",
            "Fk-Affiliate-Token: 1234567890"
    })*/
//    @GET("search.json?query=sony+mobiles&resultCount=10")
    @GET("search.json?")
    Call<ProductWrapper> getProducts(@Query("query") String searchKey);





//      "https://next.json-generator.com/api/json/get/EJGbhABKc/"
//      @GET("cpQFgtnOYy?indent=2")

}
