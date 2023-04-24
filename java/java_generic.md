# Generic 🧇
> 모든 종류의 타입을 다룰 수 있도록, 클래스나 메소드를 일반화된 타입 매개 변수(generic type)를 이용하여 선언하는 기법 
> C++의 템플릿과 유사하다

`템플릿(template)` : 템플릿은 '형판'이라는 뜻이다. C++의 템플릿이나 자바의 제너릭은 메소드나 클래스 코드를 찍어내듯이 생산할 수 있도록 일반화(generic)시키는 도구이다.

<div align='center'>
    <img src="img/java_generic_01.jpg" width="500px"/>
</div>

## 1. Generic 사용법
컬렉션 클래스에서 타입 매개 변수로 사용하는 문자는 다른 변수와 혼동을 피하기 위해 일반적으로 하나의 대문자를 사용한다. 아래는 관례적으로 타입매개변수에 많이 사용하는 문자이며, 반드시 일치할 필요는 없다.

| 타입 | 설명 | 
|------|------------|
| **`<T>`** | Type |
| **`<E>`** | Element |
| **`<K>`** | Key |
| **`<V>`** |  Value |
| **`<N>`** | Number |

## [ 클래스 및 인터페이스 선언 ]
### 1. 클래스 및 인터페이스 선언
```
public class ClassName <T> { ... }
public Interface InterfaceName <T> { ... }
```
T타입은 해당블럭 { ... } 안에서까지만 유효하다.

### 2. 제너릭 타입 두개
```
public class ClassName <T, K> { ... }
public Interface InterfaceName <T, K> { ... }

// HashMap의 경우
public class HashMap <K, V> { ... }
```
더 나아가 제너릭 타입을 두개 둘 수도 있다.
대표적으로 타입 인자를 두개 받는 컬렉션인 HashMap이 있다.

### 3. 객체 생성
```
public class MyClass <T, K> { ... }

public class Main {
    public static void main(String[] args) {
        MyClass<String, Integer> a = new MyClass<Strnig, Integer>();
    }
}
```
생성된 제너릭 클래스를 사용하기 위해서는 객체를 생성해야 한다. 이때, 구체적인 타입을 명시해주어야 한다. 위의 예제에 따르면 T는 String이 되고, K는 Integer가 된다.

이때 주의해야할 점은 파라미터로 명시할 수 있는 것은 참조 타입(Reference Type)밖에 올 수 없다는 것이다.
즉, int, double, char같은 primitive type은 올 수 없다. 그래서 int, double 같은 primitive type의 경우 Integer, Double 같은 Wrapper Type으로 사용하여야 한다.

또한, 참조타입이 올 수 있다는 것은 사용자가 정의한 클래스도 타입으로 올 수 있다는 것을 의미한다.

<br>

## [ 제너릭 클래스 ]
```
public class MyClass <K, V> { 
    private K first;
    private V second;

    void set(K first, V second) {
        this.fist = first;
        this.second = second;
    }

    K getFist() {
        return fist;
    }

    V getSecond() {
        return second;
    }
 }

public class Main {
    public static void main(String[] args) {
        MyClass<String, Integer> myclass = new MyClass<Strnig, Integer>();
        
        myclass.set("hi",10)

        System.out.println("first data : " + myclass.getFirst());
        System.out.println("K Type : " + myclass.getFirst().getClass().getName());
        System.out.println("second data : " + myclass.getSecond());
        System.out.println("V Type : " + myclass.getSecond().getClass().getName());
    }
}
```

```
출력결과

first data : hi
K Type : java.lang.String
second data : 10
V Type : java.lang.Integer
```

ClassName이란 객체를 생성할 때에 <>안에 타입 파라미터(Type parameter)를 지정한다.
만일 
ClassName<Integer, String>으로 생성하게 되면, ClassName의 E 제너릭 타입은 Integr와 String으로 변환된다.

## [ 제너릭 메소드 ]
메소드에 한정된 제너릭도 사용할 수 있다.

```
public <T> T genericMethod(T o) {   // 제너릭 메소드
    ...
}

[접근제어자] <제너릭타입> [반환타입] [메소드명] ([제너릭타입] [파라미터]) {
    // 텍스트
}
```
클래스와 달리 반환타입 이전에 <> 제너릭 타입을 선언한다.

```
// 제네릭 클래스
class MyClass<E> {
	
	private E element;	// 제네릭 타입 변수
	
	void set(E element) {	// 제네릭 파라미터 메소드
		this.element = element;
	}
	
	E get() {	// 제네릭 타입 반환 메소드 
		return element;
	}
	
	<T> T genericMethod(T o) {	// 제네릭 메소드
		return o;
	}
 
	
}
 
public class Main {
	public static void main(String[] args) {
		
		MyClass<String> a = new MyClass<String>();
		MyClass<Integer> b = new MyClass<Integer>();
		
		a.set("10");
		b.set(10);
	
		System.out.println("a data : " + a.get());
		// 반환된 변수의 타입 출력 
		System.out.println("a E Type : " + a.get().getClass().getName());
		
		System.out.println();
		System.out.println("b data : " + b.get());
		// 반환된 변수의 타입 출력 
		System.out.println("b E Type : " + b.get().getClass().getName());
		System.out.println();
		
		// 제네릭 메소드 Integer
		System.out.println("<T> returnType : " + a.genericMethod(3).getClass().getName());
		
		// 제네릭 메소드 String
		System.out.println("<T> returnType : " + a.genericMethod("ABCD").getClass().getName());
		
		// 제네릭 메소드 ClassName b
		System.out.println("<T> returnType : " + a.genericMethod(b).getClass().getName());
	}
}
```
ClassName 객체를 생성할 때 <>안에 타입 파라미터(Type Parameter)를 지정한다.

a 객체의 ClassName의 E 제너릭 타입은 String으로 모두 변환된다.
b 객체의 ClassName의 E 제너릭 타입은 Integer로 모두 변환된다.

**genericMethod()는 파라미터 타입에 따라 T타입이 결정된다.**

```
출력결과

a data : 10
a E Type : java.lang.String

b data : 10
b E Type : java.lang.Integer

<T> returnType : java.lang.Integer
<T> returnType : java.lang.String
<T> returnType : MyClass
```
클래스에서 지정한 제너릭 유형과 별도로 메소드에서 독립적으로 제너릭 유형을 선언하여 쓸 수 있다.

위와 같은 방식이 필요한 이유는 **정적 메소드로 선언할 때 필요하기 때문이다.**


* * *

### ❓ 관련 질문
Q1. 

Q2. 

Q3.


### 📖 참고 자료
[자바[Java] - 제너릭(Generic)의 이해](https://st-lab.tistory.com/153)

