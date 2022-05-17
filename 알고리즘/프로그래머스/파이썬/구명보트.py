def solution(people, limit):
    # 무게 제한에 2개의 합이 가장 가깝도록 -> 그래야 최소 개수 가능
    # 5만 이하 
    # 무게제한은 최대 몸무게보다 큼 -> 보트 하나에 인간 최소 한 명 가능
    people.sort()
    answer = 0
    start = 0
    end = len(people) - 1
    while start <= end:
        if people[start] + people[end] <= limit:
            start += 1
        end -= 1
        answer += 1
    return answer
