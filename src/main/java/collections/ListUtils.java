package collections;

import system.SystemUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by handong on 16/2/5.
 */
public class ListUtils {
    public static void list(List list){
        long start = System.currentTimeMillis();
        for(Object object : list) {
            SystemUtils.println(object);
        }
        SystemUtils.println((System.currentTimeMillis() - start));
    }

    public static List<String> removeDuplicate(List<String> list) {
        HashSet<String> h = new HashSet<String>(list);
        list.clear();
        list.addAll(h);
        return list;
    }
    public static List<String> removeDuplicateList(List<String> list) {
        List<String> list1 = new ArrayList<String>();
        for(String str : list) {
            if(!list1.contains(str)){
                list1.add(str);
            }
        }
        return list1;
    }
    public static List<String> removeDuplicateAndSort(List<String> list) {
        TreeSet<String> h = new TreeSet<String>(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    public static List<String> combineAndDup(List<String> listA,List<String> listB) {
        HashSet<String> set = new HashSet<String>();
        set.addAll(listA);
        set.addAll(listB);
        listA.clear();
        listA .addAll(set);
        return listA;
    }

    public static List<String> combinListWithOutDup(List<String> listA,List<String> listB) {
        listA.removeAll(listB);
        listA.addAll(listB);
        return listA;
    }

}
