//package StudentManagementRefactor;
//
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.text.Collator;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.LinkedHashMap; // LinkedHashMap 사용: 순서 보존을 위해
//import java.util.List;
//import java.util.Map;
//
//public class StudentDBIO extends ObjectIO<String, Student> implements StudentIO {
//    private static final StudentDBIO instance = new StudentDBIO();
//    private static final String filePath = "src/StudentManagementRefactor/students.json";
//
//    protected StudentDBIO() { }
//
//    public static StudentDBIO getInstance() {
//        return instance;
//    }
//
//    @Override
//    public Map<String, Student> loadData() {
//        // 반환 타입을 Map<String, Student>으로 변경하고, 내부 구현은 LinkedHashMap 사용
//        return parseJson();
//    }
//
//    @Override
//    public void saveData(Map<String, Student> studentMap) throws IOException {
//        // 기존 saveJson()과 동일한 기능을 수행하는 메서드입니다.
//        JSONArray studentArray = new JSONArray();
//        for (Student student : studentMap.values()) {
//            JSONObject studentObj = new JSONObject();
//            studentObj.put("sno", student.getSno());
//            studentObj.put("name", student.getName());
//            studentObj.put("korean", student.getKorean());
//            studentObj.put("english", student.getEnglish());
//            studentObj.put("math", student.getMath());
//            studentObj.put("science", student.getScience());
//            studentObj.put("total", student.getTotal());
//            studentObj.put("average", student.getAverage());
//            studentObj.put("grade", student.getGrade());
//            studentArray.add(studentObj);
//        }
//
//        JSONObject newJsonObject = new JSONObject();
//        newJsonObject.put("students", studentArray);
//
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            fileWriter.write(newJsonObject.toJSONString());
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw e; // 예외 전파
//        }
//    }
//
//    // JSON 파일을 파싱하여 LinkedHashMap으로 반환합니다.
//    // LinkedHashMap을 사용하여 데이터의 순서를 보존합니다.
//    private Map<String, Student> parseJson() {
//        Map<String, Student> students = new LinkedHashMap<>(); // 수정: HashMap -> LinkedHashMap
//        File file = new File(filePath);
//        if (!file.exists()) {
//            return students; // 파일이 없으면 빈 맵 반환
//        }
//        try {
//            String json = new String(Files.readAllBytes(Paths.get(filePath)));
//            if (json.trim().isEmpty() || json.equals("{ \"students\": [] }")) {
//                return students;
//            }
//            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
//            JSONArray jsonArray = (JSONArray) jsonObject.get("students");
//            for (Object obj : jsonArray) {
//                JSONObject studentObj = (JSONObject) obj;
//                Student student = new Student(
//                        (String) studentObj.get("sno"),
//                        (String) studentObj.get("name"),
//                        ((Long) studentObj.get("korean")).intValue(),
//                        ((Long) studentObj.get("english")).intValue(),
//                        ((Long) studentObj.get("math")).intValue(),
//                        ((Long) studentObj.get("science")).intValue(),
//                        ((Long) studentObj.get("total")).intValue(),
//                        ((Double) studentObj.get("average")).doubleValue(),
//                        (String) studentObj.get("grade")
//                );
//                students.put(student.getSno(), student);
//            }
//        } catch (IOException | ParseException e) {
//            e.printStackTrace();
//        }
//        return students;
//    }
//
//    // StudentIO 인터페이스에 정의된 메서드 구현
//    @Override
//    public void input(Student student) {
//        Map<String, Student> studentMap = loadData();
//        studentMap.put(student.getSno(), student);
//        try {
//            saveData(studentMap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("학생 정보가 입력되었습니다.");
//    }
//
//    @Override
//    public Student search(String sno) {
//        Map<String, Student> studentMap = loadData();
//        return studentMap.get(sno);
//    }
//
//    @Override
//    public Map<String, Student> sortByName() {
//        Map<String, Student> studentMap = loadData();
//        List<Student> sortedList = new ArrayList<>(studentMap.values());
//        // Java 8 스트림 대신 기본 정렬 사용, Collator로 한글 정렬 처리
//        sortedList.sort(Comparator.comparing(Student::getName, Collator.getInstance()));
//        Map<String, Student> sortedMap = new LinkedHashMap<>(); // 수정: 순서 보장을 위해 LinkedHashMap 사용
//        for (Student student : sortedList) {
//            sortedMap.put(student.getSno(), student);
//        }
//        return sortedMap;
//    }
//
//    @Override
//    public Map<String, Student> sortByTotal() {
//        Map<String, Student> studentMap = loadData();
//        List<Student> sortedList = new ArrayList<>(studentMap.values());
//        sortedList.sort(Comparator.comparingInt(Student::getTotal).reversed());
//        Map<String, Student> sortedMap = new LinkedHashMap<>(); // 수정: 순서 보장을 위해 LinkedHashMap 사용
//        for (Student student : sortedList) {
//            sortedMap.put(student.getSno(), student);
//        }
//        return sortedMap;
//    }
//
//    @Override
//    public Map<String, Student> deleteStudent(String sno) {
//        Map<String, Student> studentMap = loadData();
//        if (!studentMap.containsKey(sno)) {
//            System.out.println("학번 '" + sno + "'에 해당하는 학생을 찾을 수 없습니다.");
//            return studentMap;
//        }
//        studentMap.remove(sno);
//        try {
//            saveData(studentMap);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("학번 '" + sno + "' 학생 정보가 삭제되었습니다.");
//        return studentMap;
//    }
//
//    @Override
//    public void output() {
//        Map<String, Student> studentMap = loadData();
//        System.out.println(Student.getTableHeader());
//        for (Student student : studentMap.values()) {
//            System.out.println(student);
//        }
//    }
//}
