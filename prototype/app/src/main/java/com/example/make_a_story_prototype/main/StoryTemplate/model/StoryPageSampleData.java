package com.example.make_a_story_prototype.main.StoryTemplate.model;

import com.example.make_a_story_prototype.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoryPageSampleData {
    public static Story sampleStory() {
        List<StoryPage> pages = new ArrayList<>();
        pages.add(sampleStoryPage1());
        pages.add(sampleStoryPage2());

        Map<String, StoryBlank> blanks = blanks();

        return new Story("The Space Alien", pages, blanks);
    }

    private static StoryPage sampleStoryPage1() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("One Saturday evening "));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" and "));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" made a tent to camp out in the back yard.  They griped and whined and complained to each other about a school assignment due next week:  to stand in front of the whole class and show pictures and talk about a special place they had visited.  Neither one had any special pictures of any place special, and they both just knew the teacher would embarrass them, and the other kids would tease them, and Monday would be terrifishously, awfulishously, horrifishously bad.  Feeling glum, "));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(" snuggled tight in some blankets and "));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" curled up in a sleeping bag, when about midnight a strange-shaped shadow flickered on their tent wall.  \n"
                + "\t\"What’s that” asked "));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(".   \"Maybe some "));
        segments.add(new StoryBlankIdentifier("A-2"));
        segments.add(new StoryText(".\""));
        segments.add(new StoryBlankIdentifier("AA"));
        segments.add(new StoryText("\" Or a maybe some kind of \""));
        segments.add(new StoryBlankIdentifier("BB"));
        segments.add(new StoryText(",\" guessed "));
        segments.add(new StoryBlankIdentifier("C-2"));
        segments.add(new StoryText(" They stuck their noses outside to find a weird looking space alien just their size."));

        return new StoryPage(R.drawable.story_space_alien_1, segments);
    }

    private static StoryPage sampleStoryPage2() {
        List<StorySegment> segments = new ArrayList<>();
        segments.add(new StoryText("\"Please help me!\" \n"
                + "\t\"How?\" \t\n"
                + "\t\"For my school project I need pictures of earth stuff, and I took a few pictures but I need more.\"\n"
                + "\t\"Show us.\" \n"
                + "\tSpace Alien punched a shiny elbow button and twisted a fancy shoulder dial, and Space Alien’s tummy screen displayed a glowy"));
        segments.add(new StoryBlankIdentifier("CC"));

        segments.add(new StoryText("\"That’s a strange looking earth planet"));
        segments.add(new StoryBlankIdentifier("DD"));

        segments.add(new StoryText("\"Nope.  Actually, a pretty nice"));
        segments.add(new StoryBlankIdentifier("CC"));

        segments.add(new StoryText("\"No!  Are you sure?\" \n"
                + "\tBoth kids nodded yes. \"But my sister said— I just feel so "));
        segments.add(new StoryBlankIdentifier("FF"));

        segments.add(new StoryText(".  It makes me want to"));
        segments.add(new StoryBlankIdentifier("GG"));

        segments.add(new StoryText(".\""));

        return new StoryPage(R.drawable.story_space_alien_2, segments);
    }

    private static Map<String, StoryBlank> blanks() {
        Map<String, StoryBlank> blanks = new HashMap<>();

        blanks.put("A-2", new StoryBlank("A-2"));
        blanks.put("C-2", new StoryBlank("C-2"));
        blanks.put("AA",new StoryBlank("AA"));
        blanks.put("BB",new StoryBlank("BB"));
        blanks.put("CC",new StoryBlank("CC"));
        blanks.put("DD",new StoryBlank("DD"));
        blanks.put("FF",new StoryBlank("FF"));
        blanks.put("GG",new StoryBlank("GG"));
        blanks.put("HH",new StoryBlank("HH"));
        blanks.put("JJ",new StoryBlank("JJ"));
        blanks.put("KK",new StoryBlank("KK"));
        blanks.put("LL",new StoryBlank("LL"));
        blanks.put("MM",new StoryBlank("MM"));
        blanks.put("NN",new StoryBlank("NN"));
        blanks.put("OO",new StoryBlank("OO"));
        blanks.put("PP",new StoryBlank("PP"));
        blanks.put("QQ",new StoryBlank("QQ"));
        blanks.put("RR",new StoryBlank("RR"));
        blanks.put("SS",new StoryBlank("SS"));
        blanks.put("TT",new StoryBlank("TT"));
        blanks.put("UU",new StoryBlank("UU"));
        blanks.put("VV",new StoryBlank("VV"));
        blanks.put("XX",new StoryBlank("XX"));
        blanks.put("YY",new StoryBlank("YY"));
        blanks.put("ZZ",new StoryBlank("ZZ"));

        return blanks;
    }

}