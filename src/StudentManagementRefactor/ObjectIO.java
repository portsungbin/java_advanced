package StudentManagementRefactor;

import java.io.IOException;
import java.util.Map;

// 기존 ObjectIO는 구체적인 HashMap<String, Student> 타입을 반환했으나,
// 제네릭을 사용해 보다 범용적인 입출력 클래스로 변경했습니다.
public abstract class ObjectIO<K, V> {
    // 기존: public abstract HashMap<String, Student>
    // loadData() throws IOException;
    // 변경: Map<K, V>를 반환하도록 수정 (유연성을 위해)
    public abstract Map<K, V> loadData() throws IOException;

    // 기존에는 saveData() 메서드가 없었으므로, JSON 저장 기능을 추가했습니다.
    public abstract void saveData(Map<K, V> data) throws IOException;
}
