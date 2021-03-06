package day06;

import util.ArrayUtil;

// 배열의 동적 할당

// 배열의 동적 할당이란 현재 배열은 처음 크기를 지정해놓고, 그 크기만큼만 사용하는 "정적 할당"이다.

// 정적 할당의 경우 우리가 크기를 직접 지정해 놓았기 때문에
// 우리가 사용한 칸이든 사용하지 않은 칸이든 크기를 무조건 1씩 차지하게 된다.
// 또한, 배열의 크기를 넘어가면 에러가 발생한다.

// 이 다음의 예제에서는 Student 배열을 만들어서 만약 꽉 차게 되면 어떻게 될까? 를 2가지 방법으로 보여주게 된다.

public class Ex06DynamicAlloc {
    public static void main(String[] args) {
        int[] array = new int[0];
        System.out.println("array.length: " + array.length);
        // ArrayUtil을 사용해서 새로운 요소를 추가할때마다 크기가 늘어나는지 확인해보자
        array = ArrayUtil.add(array, 1);
        System.out.println("array.length: " + array.length);
        array = ArrayUtil.add(array, 2);
        System.out.println("array.length: " + array.length);
        array = ArrayUtil.add(array, 3);
        System.out.println("array.length: " + array.length);
        array = ArrayUtil.add(array, 4);
        System.out.println("array.length: " + array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]: %d\n", i, array[i]);
        }

        System.out.println("===================");

        // 삭제해보기
        // 1. 존재하지 않는 index
        array = ArrayUtil.removeByIndex(array, -1);
        System.out.println("잘못된 인덱스 삭제후 array.length: " + array.length);

        // 2. 가장 앞에 지워보기
        System.out.println("0번 인덱스 삭제전: " + array[0]);
        array = ArrayUtil.removeByIndex(array, 0);
        System.out.println("0번 인덱스 삭제후: " + array[0]);

        //3. 가장 마지막 지워보기
        System.out.println("2번 인덱스 삭제전: " + array[2]);
        array = ArrayUtil.removeByIndex(array, 2);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]: %d\n", i, array[i]);
        }

        // 4. 중간 삭제하기
        array = ArrayUtil.add(array, 3);
        array = ArrayUtil.add(array, 30);
        array = ArrayUtil.add(array, 300);
        array = ArrayUtil.add(array, 3000);
        System.out.println("삭제전");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]: %d\n", i, array[i]);
        }
        array = ArrayUtil.removeByIndex(array, 3);
        System.out.println("삭제후");
        for(int i = 0 ; i < array.length ; i++) {
            System.out.printf("array[%d]: %d\n", i, array[i]);
        }

        System.out.println("remove(배열, element)");
        System.out.println("ArrayUtil.indexOf(array,300): " + ArrayUtil.indexOf(array,300));
        array = ArrayUtil.remove(array, 300);
        System.out.println("ArrayUtil.indexOf(array,300): " + ArrayUtil.indexOf(array,300));

        System.out.println("ArrayUtil.indexOf(array, 555): " + ArrayUtil.indexOf(array, 555));
        array = ArrayUtil.remove(array, 300);
        System.out.println("ArrayUtil.indexOf(array, 555): " + ArrayUtil.indexOf(array, 555));

    }
}

// Ex05, Ex06처럼 정적 할당을 하는 경우 배열이 꽉차면 아래와 같은 단점이 발생
// Ex05 : 새로운 정보를 더이상 입력할 수 없음
// Ex06 : 기존 정보를 날려야 새로운 정보를 입력할 수 없음

// 따라서 크기에서 자유로운 배열을 만들고자 하면,
// 복잡한 과정을 통해 크기를 자유자재로 다루는 배열이 되어야 한다.
// 위와 같이, 크기가 자유로운 배열을 "동적 할당한다" 라고 한다. 
