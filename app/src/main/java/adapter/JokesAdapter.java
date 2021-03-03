package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fetchjokesfromapi.R;

import java.util.List;

import model.ApiResponse;

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.JokesAdapterViewHolder> {

    private ApiResponse apiResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public JokesAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void provideData(ApiResponse apiResponseList){
        this.apiResponseList = apiResponseList;
        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public JokesAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new JokesAdapter.JokesAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.row_jokes, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull JokesAdapterViewHolder holder, int position) {

        //ApiResponse apiResponse = apiResponseList.get(position);
        ApiResponse apiResponse = apiResponseList;
        //ApiResponse apiResponse = apiResponseList;
        String categoryId = apiResponse.getId();
        //String url = apiResponseList.getUrl();
        String starPref;

        if (apiResponse.getId() != null){
            starPref = "A";
            //starPref = apiResponse.getId();
            categoryId = apiResponse.getId();
            //url = apiResponse.getUrl();
        }else {
            starPref = "D";
        }
        holder.startPref.setText(starPref);
        holder.categoryId.setText(categoryId);
        holder.viewMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedJokeItem(apiResponse);
            }
        });
    }

    public interface ClickedItem{
        public void ClickedJokeItem(ApiResponse apiResponse);
    }

    @Override
    public int getItemCount() {
        //return apiResponseList.size();
        return apiResponseList.getId().length();
    }

    public class JokesAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView categoryId;
        TextView startPref;
        ImageView viewMore;

        public JokesAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryId = itemView.findViewById(R.id.categoryId);
            startPref = itemView.findViewById(R.id.startPref);
            viewMore = itemView.findViewById(R.id.viewMore);
        }
    }
}
