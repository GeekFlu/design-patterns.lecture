package mx.com.geekflu.design.pattern.factory.abstractf;

import mx.com.geekflu.design.pattern.factory.Color;
import mx.com.geekflu.design.pattern.factory.Red;
import mx.com.geekflu.design.pattern.factory.Yellow;

public class ColorFactory implements AbstractFactory<Color> {
	@Override
	public Color create(String colorType) {
		if("Red".equalsIgnoreCase(colorType)) {
			return new Red();
		}else if("Yellow".equalsIgnoreCase(colorType)) {
			return new Yellow();
		}
		return null;
	}

}
