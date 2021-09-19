package app;
import java.util.ArrayList;

/**
 *  This class provides methods that perform operations on a list of generic objects.
 *  The Objects are assumed to have an appropriate implementation of the equals method.
 */
public class ArrayListServices <T> {
   
   /**
    * This method takes an ArrayList as a parameter and returns a new ArrayList that 
    * does not contain any duplicate data. For example, if this list was passed in: 
    * [A, B, D, A, A, E, B], the method would return a list containing: [A, B, D, E]. 
    * The ordering of the data does not matter. 
    * Assume that the parameter is not null, but it may be an empty ArrayList, in which case 
    * your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the 
    * same as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> deDuplicate(ArrayList<T> inputList){
      // TODO: Implement this method.

      ArrayList<T> outputList = new ArrayList<T>();
      int len = inputList.size();
      int count=0;
      if(len>0){
         outputList.add(inputList.get(0));
         for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
               if(inputList.get(j).equals(inputList.get(i))){
                  count++;
                  break;
               }
            }
            if(count>0){
               count=0;
               continue;
            }
            else{
               outputList.add(inputList.get(i));
               
            }

         }
      }
      

         return outputList;
   }

   /**
    * This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the intersection of the data in the ArrayLists passed in. The intersection 
    * contains the elements that occur in both lists.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [B, E]. The ordering of the data does not matter. Note that 
    * the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList, in which 
    * case your method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same as 
    * the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> getSetIntersection(ArrayList<T> listA, ArrayList<T> listB){
   // TODO: Implement this method.
      ArrayList<T> listC= new ArrayList<T>();
      
      int len1= listA.size();
      int len2= listB.size();
      if(len1>0 && len2>0){
         for(T t1:listA){
            for(T t2:listB){
               if(t1.equals(t2)){
                  listC.add(t1);
               }
            }
         }
         

         listC= this.deDuplicate(listC);
      }

      return listC;
   }

   /**
    *  This method takes two ArrayLists as parameters and returns a new ArrayList that 
    * contains the set difference of the data in the ArrayLists passed in. The set difference 
    * contains the elements that occur only in one or the other list, but not in both.
    * For example, if these lists were passed in: [A, B, D, A, A, E, B], [B, E, C], the method 
    * would return a list containing: [A, C]. The ordering of the data does not matter. Note 
    * that the result does not contain any duplicates.
    * Assume that the parameters are not null, but one or both may be an empty ArrayList. In the 
    * case where one list is empty, your method returns a new ArrayList that contains all of the 
    * elements on the other list- with no duplicates. In the case where both lists are empty, your 
    * method returns a new, empty ArrayList.
    * Also note that the ArrayList that is returned must be a new ArrayList which is not the same 
    * as the ArrayList passed in. In other words, the parameter must not be changed by your method code.
    */
   public ArrayList<T> getSetDifference(ArrayList<T> listA, ArrayList<T> listB){
   // TODO: Implement this method.
   ArrayList<T> listC= new ArrayList<T>();
   ArrayList<T> intersection = new ArrayList<T>();
   
   intersection= this.getSetIntersection(listA, listB);
   int len1= listA.size();
   int len2=listB.size();
   int count1=0,count2=0;
      if(len1==0&& len2==0){
         return listC;
      }
      else{      
      for( T t1:listA){
         for(T t2:intersection){
            if(t1.equals(t2)){
               count1++;
               break;
            } 
         }
         if(count1>0){
            count1=0;
            continue;
         }
         else{
            listC.add(t1);
         }
         
      }
      for( T t3:listB){
         for(T t4:intersection){
            if(t3.equals(t4)){
               count2++;
               break;
            }
            
         }
         if(count2>0){
            count2=0;
            continue;
         }
         else{
            listC.add(t3);
         }
      }
      listC=this.deDuplicate(listC);
      
      return listC;
      }
   }
}