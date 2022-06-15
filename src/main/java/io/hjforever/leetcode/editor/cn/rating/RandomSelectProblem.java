package io.hjforever.leetcode.editor.cn.rating;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.hjforever.leetcode.editor.cn.rating.Problem;

public class RandomSelectProblem {

    static List<Problem> problems;

    static List<CompleteData> completeDatas;

    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static String basePath = new File("").getAbsolutePath() + "\\src\\main\\java\\io\\hjforever\\leetcode\\editor\\cn\\rating\\";

    static {
        try {
            String data = FileUtils.readFileToString(new File(basePath + "data.json"), "UTF-8");
            Type problemListType = new TypeToken<ArrayList<Problem>>() {
            }.getType();
            problems = gson.fromJson(data, problemListType);
            String completeJsonPath = basePath + "complete.json";

            Type completeDataListType = new TypeToken<ArrayList<CompleteData>>() {
            }.getType();
            completeDatas = gson.fromJson(FileUtils.readFileToString(new File(completeJsonPath), "UTF-8"), completeDataListType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void select(double minScore, double maxScore) {
        Map<Integer, CompleteData> completeDataMap = completeDatas.stream().collect(Collectors.toMap(CompleteData::getID, Function.identity()));
        List<Problem> list = problems.stream().filter(problem -> !completeDataMap.containsKey(problem.getID())).filter(problem -> problem.getRating() >= minScore && problem.getRating() <= maxScore).collect(Collectors.toList());
        if (list == null || list.size() <= 0) {
            System.out.println("题目已完成！，请调整分数策略");
        }
        Random random = new Random();
        List<CompleteData> doing = new ArrayList<>();
        String format = "随机选题_%d , ID:%d , title:%s , rating :%s ";
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < 3) {
            int idx = random.nextInt(list.size());
            int k = 0;
            while (set.contains(idx)) {
                idx = random.nextInt(list.size());
                k++;
                if (k > 10) {
                    continue;
                }
            }
            i++;
            if (!set.contains(idx)) {
                Problem p = list.get(idx);
                CompleteData doingData = new CompleteData();
                doingData.setID(p.getID());
                doingData.setRating(p.getRating());
                doingData.setTitle(p.getTitle());
                doing.add(doingData);
                System.out.println(String.format(format, i, p.getID(), p.getTitle(), p.getRating()));
            }
            set.add(idx);
        }
        //写入doing 文件
        try {
            FileUtils.writeStringToFile(new File(basePath + "doing.json"), gson.toJson(doing), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void complete() {
        Type completeDataListType = new TypeToken<ArrayList<CompleteData>>() {
        }.getType();
        try {
            List<CompleteData> doingList = gson.fromJson(FileUtils.readFileToString(new File(basePath + "doing.json"), "UTF-8"), completeDataListType);
            String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            for (CompleteData data : doingList) {
                data.setCompleteTime(time);
                data.setTimestamp(new Date().getTime());
            }
            completeDatas.addAll(doingList);
            Collections.sort(doingList, (o1, o2) -> (int) (o2.getTimestamp() - o1.getTimestamp()));
            FileUtils.writeStringToFile(new File(basePath + "complete.json"), gson.toJson(completeDatas), "UTF-8");
            FileUtils.writeStringToFile(new File(basePath + "doing.json"), "", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        select(1500, 1600);
        //complete();
    }
}
