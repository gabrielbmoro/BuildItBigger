package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.util.Pair;

import com.example.jokesjavalibrary.ProvidesJokes;
import com.google.common.truth.Truth;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.robolectric.annotation.Config;

@Config(manifest = Config.NONE)
@RunWith(MockitoJUnitRunner.class)
public class EndpointsAsyncTaskTest {

    private EndpointsAsyncTask task;

    @Before
    public void setUp() {
        task = Mockito.mock(EndpointsAsyncTask.class);
    }

    /**
     * Template: methodToBeTest_exceptedReturn_condition
     */
    @Test
    public void execute_True_ifTheResultIsThisIsTotallyFunnyJoke() {
        final String correctResult = "This is totally a funny Joke";

        task.setContract(new EndpointsAsyncTask.CallbackAsyncTask() {
            @Override
            public void onPostExecute(String resultArgument) {
                Truth.assertThat(resultArgument.equals(correctResult)).isTrue();
            }
        });

        task.execute(new Pair<Context, String>(Mockito.mock(Context.class), new ProvidesJokes().getJoke()));
    }
}
