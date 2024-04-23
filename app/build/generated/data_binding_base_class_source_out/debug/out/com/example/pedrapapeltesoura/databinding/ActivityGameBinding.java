// Generated by view binder compiler. Do not edit!
package com.example.pedrapapeltesoura.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.pedrapapeltesoura.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityGameBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView aplicativo1Tv;

  @NonNull
  public final TextView escolhaTv;

  @NonNull
  public final ImageView imgAplicativo1;

  @NonNull
  public final ImageView imgPaper;

  @NonNull
  public final ImageView imgScizor;

  @NonNull
  public final ImageView imgStone;

  @NonNull
  public final Button jogarBt;

  @NonNull
  public final LinearLayout linerLayout;

  @NonNull
  public final ToolbarBinding toolbarIn;

  private ActivityGameBinding(@NonNull ConstraintLayout rootView, @NonNull TextView aplicativo1Tv,
      @NonNull TextView escolhaTv, @NonNull ImageView imgAplicativo1, @NonNull ImageView imgPaper,
      @NonNull ImageView imgScizor, @NonNull ImageView imgStone, @NonNull Button jogarBt,
      @NonNull LinearLayout linerLayout, @NonNull ToolbarBinding toolbarIn) {
    this.rootView = rootView;
    this.aplicativo1Tv = aplicativo1Tv;
    this.escolhaTv = escolhaTv;
    this.imgAplicativo1 = imgAplicativo1;
    this.imgPaper = imgPaper;
    this.imgScizor = imgScizor;
    this.imgStone = imgStone;
    this.jogarBt = jogarBt;
    this.linerLayout = linerLayout;
    this.toolbarIn = toolbarIn;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityGameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityGameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_game, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityGameBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aplicativo1Tv;
      TextView aplicativo1Tv = ViewBindings.findChildViewById(rootView, id);
      if (aplicativo1Tv == null) {
        break missingId;
      }

      id = R.id.escolhaTv;
      TextView escolhaTv = ViewBindings.findChildViewById(rootView, id);
      if (escolhaTv == null) {
        break missingId;
      }

      id = R.id.imgAplicativo1;
      ImageView imgAplicativo1 = ViewBindings.findChildViewById(rootView, id);
      if (imgAplicativo1 == null) {
        break missingId;
      }

      id = R.id.imgPaper;
      ImageView imgPaper = ViewBindings.findChildViewById(rootView, id);
      if (imgPaper == null) {
        break missingId;
      }

      id = R.id.imgScizor;
      ImageView imgScizor = ViewBindings.findChildViewById(rootView, id);
      if (imgScizor == null) {
        break missingId;
      }

      id = R.id.imgStone;
      ImageView imgStone = ViewBindings.findChildViewById(rootView, id);
      if (imgStone == null) {
        break missingId;
      }

      id = R.id.jogarBt;
      Button jogarBt = ViewBindings.findChildViewById(rootView, id);
      if (jogarBt == null) {
        break missingId;
      }

      id = R.id.linerLayout;
      LinearLayout linerLayout = ViewBindings.findChildViewById(rootView, id);
      if (linerLayout == null) {
        break missingId;
      }

      id = R.id.toolbarIn;
      View toolbarIn = ViewBindings.findChildViewById(rootView, id);
      if (toolbarIn == null) {
        break missingId;
      }
      ToolbarBinding binding_toolbarIn = ToolbarBinding.bind(toolbarIn);

      return new ActivityGameBinding((ConstraintLayout) rootView, aplicativo1Tv, escolhaTv,
          imgAplicativo1, imgPaper, imgScizor, imgStone, jogarBt, linerLayout, binding_toolbarIn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
