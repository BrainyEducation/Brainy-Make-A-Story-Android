package com.example.make_a_story_prototype.main.StoryTemplate.vm;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Story {
    private List<StoryPage> pages;
    private List<StoryBlank> blanks;

    public Story(List<StoryPage> pages, List<StoryBlank> blanks) {
        this.pages = pages;
        this.blanks = blanks;
    }
}

class StoryBlank {
    class ImageLocation {
        float x;
        float y;
        float width;
        float height;
        float rotation;
    }

    StoryBlankIdentifier identifier;
    ImageLocation imageLocation;

    public StoryBlank(StoryBlankIdentifier identifier) {
        this(identifier, null);
    }

    public StoryBlank(StoryBlankIdentifier identifier, ImageLocation imageLocation) {
        this.identifier = identifier;
        this.imageLocation = imageLocation;
    }
}

interface StorySegment {}

class StoryBlankIdentifier implements StorySegment {
    private String identifier;

    public String get() {
        return identifier;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    public StoryBlankIdentifier(String identifier) {
        this.identifier = identifier;
    }
}

class StoryText implements StorySegment {
    String text;
    // audio file

    public StoryText(String text) {
        this.text = text;
    }
}

class StoryPageSampleData {
    static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage());

        List<StoryBlank> blanks = new ArrayList<>();
        // TODO:

        return new Story(pages, blanks);
    }

    static StoryPage sampleStoryPage() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("One Saturday evening"));
        segments.add(new StoryText("and"));
        segments.add(new StoryText("made a tent to camp out in the back yard.  They griped and whined and complained to each other about a school assignment due next week:  to stand in front of the whole class and show pictures and talk about a special place they had visited.  Neither one had any special pictures of any place special, and they both just knew the teacher would embarrass them, and the other kids would tease them, and Monday would be terrifishously, awfulishously, horrifishously bad.  Feeling glum, "));
        segments.add(new StoryText("snuggled tight in some blankets and"));
        segments.add(new StoryText("curled up in a sleeping bag, when about midnight a strange-shaped shadow flickered on their tent wall.  \n" +
                "\t\"What’s that” asked "));
        segments.add(new StoryText(".   \"Maybe some"));
        segments.add(new StoryText(".\""));
        segments.add(new StoryText("\"Or a maybe some kind of \"["));
        segments.add(new StoryText(",\" guessed "));
        segments.add(new StoryText("They stuck their noses outside to find a weird looking space alien just their size."));
        segments.add(new StoryText("\"Please help me!\" \n" +
                "\t\"How?\" \t\n" +
                "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n" +
                "\t\"Show us.\" \n" +
                "\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy"));
        segments.add(new StoryText("\"That’s a strange looking earth planet"));
        segments.add(new StoryText("\"Nope.  Actually, a pretty nice"));
        segments.add(new StoryText("\"No!  Are you sure?\" \n" +
                "\tBoth kids nodded yes."));

        return new StoryPage(R.drawable.story_santas_elf, segments);
    }
}

class StoryPage {
    private int imageResource;
    private List<StorySegment> segments;

    public StoryPage(int imageResource, List<StorySegment> segments) {
        this.imageResource = imageResource;
        this.segments = segments;
    }
}

class StoryViewModel {
    class BlankSelection {
        String text;
        int image;
    }

    private Story story;
    private Map<StoryBlankIdentifier, BlankSelection> selections;

    public Story getStory() {
        return story;
    }

    public StoryViewModel(Story story) {
        this.story = story;
        this.selections = new HashMap<>();
    }

    public void setSelection(StoryBlankIdentifier blankIdentifier, BlankSelection selection) {
        selections.put(blankIdentifier, selection);
        // fire observable
    }

}