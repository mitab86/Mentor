package com.example.mitab.mentor.Movies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mitab.mentor.Movies.Pages.PageFragment;
import com.example.mitab.mentor.Movies.Pages.Popular.PopularFragment;
import com.example.mitab.mentor.Movies.Pages.PageFragment3;
import com.example.mitab.mentor.Movies.Pages.TopRated.TopratedFragment;

/**
 * Created by Mitab on 1/10/2016.
 */
public class SampleFragmentPagerAdapter extends FragmentStatePagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "Now Playing", "Popular" ,"Upcoming","Top Rated" };
    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PageFragment.newInstance(position );
            case 1:
                return PopularFragment.newInstance("","" );
            case 2:
                return PageFragment3.newInstance(position );
            case 3:
                return TopratedFragment.newInstance("","");
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
