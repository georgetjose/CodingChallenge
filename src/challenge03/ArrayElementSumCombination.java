package challenge03;

public class ArrayElementSumCombination {

	public static void main(String[] args) 
	{
		int myArray[] = {2,7,11,15};
		int target =18, index1=0, index2=0;
		for(int myArrayIndex1=0;myArrayIndex1<myArray.length;myArrayIndex1++)
		{
			for(int myArrayIndex2=1;myArrayIndex2<myArray.length;myArrayIndex2++)
			{
				if(myArray[myArrayIndex1]+myArray[myArrayIndex2]==target)
				{
					index1=myArrayIndex1;
					index2=myArrayIndex2;
					break;
				}
			}
		}
		System.out.println("Output:["+index1+","+index2+"]");
	}

}
