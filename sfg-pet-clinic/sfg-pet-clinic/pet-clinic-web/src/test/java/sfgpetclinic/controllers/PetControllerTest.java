//package sfgpetclinic.controllers;
//
//
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import services.OwnerService;
//import services.PetService;
//import services.PetTypeService;
//
//@ExtendWith(MockitoExtension.class)
//class PetControllerTest {
//
//    @Mock
//    PetService petService;
//
//    @Mock
//    OwnerService ownerService;
//
//    @Mock
//    PetTypeService petTypeService;
//
//    @InjectMocks
//     petController;
//
//    MockMvc mockMvc;
//
//    Owner owner;
//    Set<PetType> petTypes;
//
//    @BeforeEach
//    void setUp() {
//        owner = Owner.builder().id(1l).build();
//
//        petTypes = new HashSet<>();
//        petTypes.add(PetType.builder().id(1L).name("Dog").build());
//        petTypes.add(PetType.builder().id(2L).name("Cat").build());
//
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(petController)
//                .build();
//    }
//
//    @Test
//    void initCreationForm() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(owner);
//        when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(get("/owners/1/pets/new"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("owner"))
//                .andExpect(model().attributeExists("pet"))
//                .andExpect(view().name("pets/createOrUpdatePetForm"));
//    }
//
//    @Test
//    void processCreationForm() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(owner);
//        when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(post("/owners/1/pets/new"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//
//        verify(petService).save(any());
//    }
//
//    @Test
//    void initUpdateForm() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(owner);
//        when(petTypeService.findAll()).thenReturn(petTypes);
//        when(petService.findById(anyLong())).thenReturn(Pet.builder().id(2L).build());
//
//        mockMvc.perform(get("/owners/1/pets/2/edit"))
//                .andExpect(status().isOk())
//                .andExpect(model().attributeExists("owner"))
//                .andExpect(model().attributeExists("pet"))
//                .andExpect(view().name("pets/createOrUpdatePetForm"));
//    }
//
//    @Test
//    void processUpdateForm() throws Exception {
//        when(ownerService.findById(anyLong())).thenReturn(owner);
//        when(petTypeService.findAll()).thenReturn(petTypes);
//
//        mockMvc.perform(post("/owners/1/pets/2/edit"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(view().name("redirect:/owners/1"));
//
//        verify(petService).save(any());
//    }
//
//    @Test
//    void populatePetTypes() {
//        //todo impl
//    }
//
//    @Test
//    void findOwner() {
//        //todo impl
//    }
//
//    @Test
//    void initOwnerBinder() {
//        //todo impl
//    }
//}