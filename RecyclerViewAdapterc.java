package com.example.lab_05;



        import android.content.Context;
        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.core.app.NotificationCompatExtras;
        import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapterc extends RecyclerView.Adapter<RecyclerViewAdapterc.MyViewHolder> {
    int[] arr;
    String[] arr1;
    String[] arrp;
    String[] arrd;
    int[] quantities;
    Context context;

    public RecyclerViewAdapterc (int[] arr, String[] arr1,String[] arrp,String[] arrd ,Context context) {
        this.arr = arr;
        this.arr1 = arr1;
        this.arrd=arrd;
        this.arrp=arrp;
        this.context=context;
        this.quantities = new int[arr.length];
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arr[position]);
        holder.textView.setText(arr1[position]);
        holder.price.setText(arrp[position]);
        holder.quantityTextView.setText(String.valueOf(quantities[position]));

        final int itemPosition = position; // Declare as effectively final

        // Increase button click listener
        holder.increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantities[itemPosition]++;
                holder.quantityTextView.setText(String.valueOf(quantities[itemPosition]));
            }
        });

        // Decrease button click listener
        holder.decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantities[itemPosition] > 0) {
                    quantities[itemPosition]--;
                    holder.quantityTextView.setText(String.valueOf(quantities[itemPosition]));
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        return arr.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageView;
        TextView textView;
        TextView quantityTextView;
        ImageButton increaseButton;
        ImageButton decreaseButton;
        TextView price;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.textview);
            itemView.setOnClickListener(this);
            quantityTextView = itemView.findViewById(R.id.q1); // Replace with your actual ID
            increaseButton = itemView.findViewById(R.id.increaseButton);
            decreaseButton = itemView.findViewById(R.id.decreaseButton);
            price=itemView.findViewById(R.id.price);
        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, DisplayActivity.class);
            intent.putExtra("image",arr[getAdapterPosition()]);
            intent.putExtra("title",arr1[getAdapterPosition()]);
            intent.putExtra("price",arrp[getAdapterPosition()]);
            intent.putExtra("quantity", quantities[getAdapterPosition()]);
            intent.putExtra("desc",arrd[getAdapterPosition()]);
            context.startActivity(intent);
        }
    }
}
