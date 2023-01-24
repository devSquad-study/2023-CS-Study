# 네트워크 토폴로지(Network Topology)

> 노드(node)와 링크(link) 배치 방식 및 연결 형태를 의미한다.

**노드** : 서버, 라우터, 스위치 등 네트워크 장치

**링크** : 유선, 무선


### 물리적 토폴로지 vs 논리적 토폴로지

- **물리적 토폴로지** : 노드, 링크와 같은 네트워크 구성 요소들의 배치에 의해 결정된다.  

- **논리적 토폴로지** : 노드들 사이 데이터 흐름에 의해 결정된다.   


![image descriptionn](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbUjD1k%2FbtqzGrKQkMk%2FLoB3EoQebjtLGLcvT1KAWK%2Fimg.png)


예를 들어 위 그림과 같이 네트워크가 물리적으로 연결되어 있고 붉은색 화살표 방향으로 데이터가 순차적으로 흐른다면, 물리적 토폴로지는 `스타(Star, 성형)`이고 논리적 토폴로지는 `링형(Ring)`이다.


### 토폴로지 종류:

1. 트리(tree)
2. 버스(bus)
3. 스타(star)
4. 링(ring)
5. 메시(mesh)

### 트리(tree)형 토폴로지(= 계층형 토폴로지)

- 트리 형태로 배치한 네트워크 구성을 의미한다.

<img src="https://mblogthumb-phinf.pstatic.net/20130604_93/hilineisp_13703358174843to9j_PNG/%B3%AA%B9%AB%C7%FC%28tree%29_copy.png?type=w2" width="400" height="350"/>


#### 장점
1. 노드 추가 및 삭제 용이
2. 관리 용이


#### 단점
1. 병목 현상 및 네트워크 장애 발생 가능
    - 상위에 트래픽이 집중되어 병목 현상 발생할 수 있고, 상위 노드에 트래픽이 집중될 때 하위 노드에 영향을 미칠 수 있다.
 

### 버스(bus)형 토폴로지

- 중앙 통신 회선 하나에 여러 개의 노드가 연결되어 공유하는 네트워크 구성을 의미한다. 근거리 통신망(LAN, Local Area Network)에서 사용한다.</br></br>

<img src="https://mblogthumb-phinf.pstatic.net/20130604_122/hilineisp_1370335689681NmmBn_PNG/%B9%F6%BD%BA%C7%FC_copy.png?type=w2" width="400" height="350"/></br></br>


#### 장점
1. 설치 비용 낮음
2. 신뢰성 우수
3. 노드 추가 및 삭제 용이


#### 단점
1. 스푸핑 발생 가능</br></br>

<span style='background-color: #ffdce0'>스푸핑(Spoofing)</span>
- LAN 상에서 송신부의 패킷을 송신과 관련 없는 다른 호스트에 가지 않도록 하는 스위칭 기능을 마비시키거나 속여서 특정 노드에 해당 패킷이 오도록 처리하는 것을 의미한다. 이를 이용하여 외부의 악의적인 네트워크 침입자가 웹사이트를 구성하여 사용자들의 방문을 유도, 인터넷 프로토콜인 TCP/IP의 구조적 결함을 이용해 사용자의 시스템 권한을 획득 후, 정보를 빼가기도 한다.

<img src="https://t1.daumcdn.net/cfile/tistory/990A754C5C45B60C2C" width="500" height="250"/></br>


### 스푸핑의 종류:
1. IP 스푸핑
2. ARP 스푸핑
3. DNS 스푸핑
</br></br>

### 스타(star)형 토폴로지
- 중앙에 있는 노드에 모두 연결된 네트워크 구성을 의미한다.</br></br>

<img src="https://mblogthumb-phinf.pstatic.net/20130604_49/hilineisp_1370335852717YYBUW_PNG/%BC%BA%C7%FC%28star%29_copy.png?type=w2" width="400" height="350"/></br>

#### 장점
1. 노드 추가 용이
2. 에러 탐지 용이
3. 장애 노드가 다른 노드에 영향 끼치는 경우 적음
4. 패킷 충돌 가능성 낮음


#### 단점
1. 중앙 노드에 장애 발생 시 전체 네트워크에 영향
2. 설치 비용 높음</br></br>


### 링(ring)형 토폴로지
- 전체적으로 고리처럼 하나의 연속된 길을 통해 통신을 하는 망 구성 방식을 의미한다.</br></br>

<img src="https://mblogthumb-phinf.pstatic.net/20130604_38/hilineisp_13703357523259PgJQ_PNG/%B8%B5%C7%FC_copy.png?type=w2" width="400" height="350"/></br>


#### 장점
1. 노드 추가 용이
2. 충돌 발생 가능성 적음
3. 장애 노드 발견 용이


#### 단점
1. 네트워크 구성 변경 어려움
2. 회선 장애 발생 시, 전체 네트워크에 영향</br></br>

### 메시(mesh)형 토폴로지(= 망형 토폴로지)

- 그물망처럼 연결되어 있는 구조를 의미한다.</br></br>

<img src="https://mblogthumb-phinf.pstatic.net/20130604_241/hilineisp_1370335890628X9v0C_PNG/%B8%C1%C7%FC%28mesh%29_copy.png?type=w2" width="400" height="350"/> </br>


#### 장점
1. 장애 노드가 다른 노드에 영향 끼치는 경우 적음
2. 트래픽 분산 처리 가능


#### 단점
1. 노드 추가 어려움
2. 구축/운용 비용 높음  


# 병목 현상(bottleneck)
> 전체 시스템의 성능이나 용량이 하나의 구성 요소로 인해 제한을 받는 현상을 의미한다.   


<img src="https://velog.velcdn.com/images/rlaghdtlr012/post/261f99bc-a3b2-4813-b0aa-cbff17daf51b/image.png" width="400" height="350"/> 


### 해결책
- 네트워크 토폴로지 종류 및 어떠한 경로로 이루어져 있는지 알아야 해결 가능하다.