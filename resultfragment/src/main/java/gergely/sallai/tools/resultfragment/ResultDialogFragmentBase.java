package gergely.sallai.tools.resultfragment;

import android.app.Activity;
import android.app.DialogFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A DialogFragment that can return results to it's caller.
 * Extending this class will handle the most common result listener use cases:
 *      1.) Calling Activity implements the listener
 *      2.) TargetFragment implements the listener
 * Ability to manually add listeners.
 * @param <T> the type of the ResultListener, must extend ResultFragmentBase.ResultListener
 */
public abstract class ResultDialogFragmentBase<T extends ResultDialogFragmentBase.ResultListener> extends DialogFragment {

    /**
     * Interface to be extended by the actual listener interface.
     * Use this when you create the listener for your fragments.
     */
    public interface ResultListener { };

    private final List<T> listeners = new ArrayList<T>();

    @Override
    public void onStart() {
        super.onStart();
        if (getTargetFragment() instanceof ResultListener) {
            addListener((T) getTargetFragment());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (getTargetFragment() instanceof ResultListener) {
            removeListener((T) getTargetFragment());
        }
    }

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof ResultListener) {
            addListener((T) activity);
        }
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        if (getActivity() instanceof ResultListener) {
            removeListener((T) getActivity());
        }
        super.onDetach();
    }

    /**
     * Adds a listener to the listeners list.
     * This listener will not be retained across all instances!
     * On a Fragment recreation the manually added listeners will be removed. They will need to be added again.
     * (This is not the case when the listener is automatically recognized.
     * E.g.: The Activity or the targetFragment implements the listener)
     * @param resultListener the listener, that is added manually
     */
    public final void addListener(T resultListener) {
        listeners.add(resultListener);
    }

    /**
     * Removes a manually added listener.
     * @param resultListener the listener to be removed
     */
    public final void removeListener(T resultListener) {
        listeners.remove(resultListener);
    }

    /**
     * Get the list of listeners
     * @return the listeners, that should be notified about results
     */
    protected final Iterable<T> getListeners() {
        return listeners;
    }
}

