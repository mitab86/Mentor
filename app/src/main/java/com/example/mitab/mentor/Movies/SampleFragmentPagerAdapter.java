package com.example.mitab.mentor.Movies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.mitab.mentor.Movies.Pages.PageFragment;
import com.example.mitab.mentor.Movies.Pages.PageFragment2;
import com.example.mitab.mentor.Movies.Pages.PageFragment3;

/**
 * Created by Mitab on 1/10/2016.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PageFragment.newInstance(position + 1);
            case 1:
                return PageFragment2.newInstance(position + 1);
            case 2:
                return PageFragment3.newInstance(position + 1);
        }
        return null;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}