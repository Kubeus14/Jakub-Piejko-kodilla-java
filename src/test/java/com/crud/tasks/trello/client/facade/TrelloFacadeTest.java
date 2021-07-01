package com.crud.tasks.trello.client.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.client.TrelloBoardDto;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TrelloFacadeTest {
    @Autowired
    private TrelloFacade trelloFacade;
    @MockBean
    private TrelloService trelloService;

    @Autowired
    private TrelloMapper trelloMapper;

    @MockBean
    private TrelloValidator trelloValidator;
    @Test
    public void testFetchTrelloBoardsEmpty(){
        //Given
        List<TrelloListDto> listsTrello = new ArrayList<>();
        listsTrello.add(new TrelloListDto("1","lista",false));

        List<TrelloBoardDto> boardTrello = new ArrayList<>();
        boardTrello.add(new TrelloBoardDto("1","tablica",listsTrello));

        List<TrelloList> mapListsTrello = new ArrayList<>();
        mapListsTrello.add(new TrelloList("1","lista",false));

        List<TrelloBoard> mapBoardTrello = new ArrayList<>();
        mapBoardTrello.add(new TrelloBoard("1","tablica",mapListsTrello));

        when(trelloService.fetchTrelloBoards()).thenReturn(boardTrello);
        when(trelloMapper.mapToBoards(boardTrello)).thenReturn(mapBoardTrello);
        when(trelloMapper.mapToBoardsDto(anyList())).thenReturn(new ArrayList<>());
        when(trelloValidator.validateTrelloBoards(mapBoardTrello)).thenReturn(new ArrayList<>());
        //When
        List<TrelloBoardDto> trelloBoardResult = trelloFacade.fetchTrelloBoards();
        //Then
        assertNotNull(trelloBoardResult);
        assertEquals(0,trelloBoardResult.size());
    }
    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloListDto> listsTrello = new ArrayList<>();
        listsTrello.add(new TrelloListDto("1", "lista", false));

        List<TrelloBoardDto> boardTrello = new ArrayList<>();
        boardTrello.add(new TrelloBoardDto("1", "tablica", listsTrello));

        List<TrelloList> mapListTrello = new ArrayList<>();
        mapListTrello.add(new TrelloList("1", "lista", false));

        List<TrelloBoard> mapTrelloBoard = new ArrayList<>();
        mapTrelloBoard.add(new TrelloBoard("1", "tablica", mapListTrello));

        when(trelloService.fetchTrelloBoards()).thenReturn(boardTrello);
        when(trelloMapper.mapToBoards(boardTrello)).thenReturn(mapTrelloBoard);
        when(trelloMapper.mapToBoardsDto(anyList())).thenReturn(boardTrello);
        when(trelloValidator.validateTrelloBoards(mapTrelloBoard)).thenReturn(mapTrelloBoard);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloFacade.fetchTrelloBoards();

        //Then
        assertNotNull(trelloBoardDtos);
        assertEquals(1, trelloBoardDtos.size());


    }
}




