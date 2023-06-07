package com.jewelcse.hello.adapter;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jewelcse.hello.db.Cart;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    private List<Cart> cartItems;

    public CartAdapter(List<Cart> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @NotNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CartAdapter.CartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
