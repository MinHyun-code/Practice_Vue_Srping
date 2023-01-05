package com.example.demo.common.paging;

public class Paging {
	
	/* 페이징 처리용 */
	private static int page = 1;
	private static int pageSize = 10;
	private static int start;
	private static int end;
	private static int totalPages;
    
	public static int pageSize(int totalCount, int page) {
		
        totalPages = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            totalPages++;
        }
        if (totalPages == 0) {
            totalPages = 1;
        }
        end = page * pageSize >= totalCount ? totalCount : page * pageSize;
        start = (page - 1) * pageSize + 1;

        start--;
        if (start > end) {
            start = 0;
            end = 0;
        }
        
        return pageSize; 
    }
	
	public static int startPage(int totalCount, int page) {
		
        totalPages = totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            totalPages++;
        }
        if (totalPages == 0) {
            totalPages = 1;
        }
        end = page * pageSize >= totalCount ? totalCount : page * pageSize;
        start = (page - 1) * pageSize + 1;

        start--;
        if (start > end) {
            start = 0;
            end = 0;
        }
        
        return start; 
    }
	 
}
