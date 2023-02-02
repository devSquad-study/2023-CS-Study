## Concept of Paging

* `Paging`은 프로세스의 가상 주소 공간을 **고정적인 크기(fixed-sized)로 나누어서 메모리에 할당**하는 방식이다. 이때 고정적인 크기 단위를 `page`라고 부른다.

* 그리고 이러한 가상공간의 page 를 실제 메모리에 할당할 때 이를 `page frame`이라고 부른다.

* 즉 가상 메모리(주소 공간)에서는 page, 실제 메모리(주소 공간)에서는 frame 이라고 불리는 고정 크기의 공간으로 프로세스를 실행하겠다는 의미이다.

## Advantages Of Paging

* **Flexibility** : 주소 공간의 추상화를 효율적으로 지원한다.

    * 얼마나 heap과 stack이 커지고 사용하는지에 대한 고민을 할 필요가 없다.

* **Simplicity** : 여유 공간(free-space)의 관리가 쉽다.

    * 가상 메모리의 page와 page frame이 같은 크기를 가진다.

    * 할당이 쉽고 여유 공간을 유지한다.

## A Simple Paging

* **128-byte physical memory** with 16 bytes `page frames`

* **64-byte address space** with 16 bytes `pages`

<img src="img/os_paging_1.png" width="600px">

* 위의 그림에서 4개의 page로 구성된 가상 주소 공간을 8개의 page frame으로 쪼갠 것을 볼 수 있다.

## How To Store Address Translation

* Paging 기법을 사용하기 위해서 가상 주소 공간에 있는 프로세스의 `page`들이 실제 메모리의 어디에 위치를 하는 지를 기억하는 `Page table`을 가지고 있어야 한다.

<img src="img/os_paging_1_2.png" width="350px">

* `Page table` 이란 가상 주소 공간의 page가 실제 메모리(주소 공간)에 어디에 위치해 있는 지를 기록한다.

    * Per-process structure(프로세스별 구조)

    * OS 메모리의 영역에 저장된다.

## Address Translation

* **Paging 기법을 이용하여 주소 변환을 구하는 방법**에 대해 알아보자.

* 가상 주소 공간에는 두 가지 요소가 있다.

    * VPN : **V**irtual **P**age **N**umber -> 상위 2개의 bit이 Page를 표현한다.

    * Offset : page 안에 있는 offset -> 나머지 4개의 bit이 offset을 표현한다.

<img src="img/os_paging_2.png" width="350px">

* Example: virtual address **21** in 64-byte address space

<img src="img/os_paging_3.png" width="350px">

A Simple 64-byte Address Space

<img src="img/os_paging_4.png" width="350px">

* Page table을 통해서 Virtual Page, Physical Page frame 의 i번째를 찾는다.

    * VPN 에서 상위 2개의 bit 값이 1이므로 page 1에 해당한다.

* Offset을 통해 그 Page 안에 몇번째 메모리 주소인지 찾는다.

    * offset 값이 5이므로 16부터 시작해서 5번째인 21를 의미한다.


## Example: Address Translation

* The virtual address 21 in 64-byte address space

<img src="img/os_paging_5.png" width="500px">

* 가상 주소 공간에서 VPN 값을 Page Table을 통해 해당하는 값을 찾아서 실제 주소 공간의 PFN 값을 찾는다.

    * VPN 값 : 01 -> Page table 01에 해당 하는 값은 7 (= PFN 값)

    * PFN = Physical Frame Number (= PPN, Physical Page Number)

## Reference

* 학교 수업 내용 - [Operating Systems Three Easy Pieces (Remzi H. Arpaci-Dusseau & Andrea C. Arpaci-Dusseau)](https://www.amazon.com/Operating-Systems-Three-Easy-Pieces/dp/198508659X)

* [[OS] Paging을 사용한 고정 크기 메모리 관리 및 추상화](https://icksw.tistory.com/148)
