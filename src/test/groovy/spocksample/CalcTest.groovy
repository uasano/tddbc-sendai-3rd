package spocksample

import org.spockframework.compiler.model.ExpectBlock;

import spock.lang.Specification;

class CalcTest extends Specification{
	def "1たす1は２になるべき"(){
		given:
			def sut = new Calc();
		expect:
			sut.add(i1,i2) == answer
		where:
			i1|i2|answer
			1 |1 |2
	}
}
