package sample

import spock.lang.Specification
import spock.lang.Unroll;

class CloseRangeSpec extends Specification{

	@Unroll
	def "#expected~8の閉区間における下端点は#expectedであるべき"() {
		given:
		def sut = new CloseRange(expected, 8)

		expect:
		sut.lower == expected

		where:
		expected << [-1, 0, 7, 8]
	}


	@Unroll
	def "-1~#expectedの閉区間における上端点は#expectedであるべき"() {
		given:
		def sut = new CloseRange(-1, expected)

		expect:
		sut.upper == expected

		where:
		expected << [-1, 0, 1]
	}

	def "1~0（大小が逆転した）の閉区間はIlegalArgumentExceptionが発生すべき"() {
		when:
		new CloseRange(1, 0)

		then:
		thrown(IllegalArgumentException)
	}

	@Unroll
	def "#lower~#upperの閉区間の文字列は#expectedであるべき"() {

		given:
		def sut = new CloseRange(lower, upper)

		expect:
		sut.toString() == expected

		where:
		lower | upper | expected
		-1 | 0 | '[-1,0]'
		0 | 1 | '[0,1]'
		1 | 2 | '[1,2]'
	}

	@Unroll
	def "#lower~#upperの閉区間のcontainsに#comparedを渡したら#expectedであるべき"() {
		given:
		def sut = new CloseRange(lower, upper)

		expect:
		sut.contains(compared) == expected

		where:
		lower | upper | compared | expected
		3 | 8 | 2 | false
		3 | 8 | 3 | true
		3 | 8 | 4 | true
		3 | 8 | 7 | true
		3 | 8 | 8 | true
		3 | 8 | 9 | false
	}

	@Unroll
	def "3~8の閉区間のequalsに#lower~#upperの閉区間を渡したら#expectedであるべき"() {
		given:
		def sut = new CloseRange(3, 8)

		expect:
		sut.equals(new CloseRange(lower, upper)) == expected

		where:
		lower | upper | expected
		3 | 8 | true
		2 | 8 | false
		3 | 9 | false
	}

	@Unroll
	def "3~8の閉区間のisConnectedToに#lower~#upperの閉区間を渡したら#expectedであるべき"() {
		given:
		def sut = new CloseRange(3, 8)

		expect:
		sut.isConnectedTo(new CloseRange(lower, upper)) == expected

		where:
		lower | upper | expected
		1| 2| false
		2| 3| true
		3| 4| true
		4| 5| true
		7| 8| true
		8| 9| true
		9| 10| false
		2| 9| true
	}
}
