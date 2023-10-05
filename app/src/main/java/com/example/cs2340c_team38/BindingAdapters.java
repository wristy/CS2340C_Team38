import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter("characterSpriteId")
    public static void setCharacterSpriteId(ImageView view, int resourceId) {
        view.setImageResource(resourceId);
    }
}