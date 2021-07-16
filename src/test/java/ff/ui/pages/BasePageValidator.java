package ff.ui.pages;

import ff.ui.pages.BasePageElementMap;

public class BasePageValidator <M extends BasePageElementMap>
{    
	private M Map;

	BasePageValidator(M Map)
	{		
		this.Map =  Map;
	}
	
	public M getMap()
	{		
		return  Map;
	}	
}

